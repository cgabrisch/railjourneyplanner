package de.cgabrisch.railjourneyplanner.service.domain;

import static de.cgabrisch.railjourneyplanner.service.domain.RouteBuilder.route;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RouteRepositoryTest {
    private RouteRepository routeRepository;
    private List<Route> foundRoutes;

    @BeforeEach
    void setup() {
        this.routeRepository = new RouteRepository();
        this.foundRoutes = Collections.emptyList();
    }

    @Test
    void findsAllRoutesRunningToGivenStation() {
        given(route("Route 1", "City A", "City D").via("City B").via("City C"));
        given(route("Route 2", "City A", "City C").via("City X").via("City Y"));

        whenFindingRoutesByStation("City A");
        thenRoutesAreFound("Route 1", "Route 2");

        whenFindingRoutesByStation("City B");
        thenRoutesAreFound("Route 1");
        thenRoutesAreNotFound("Route 2");

        whenFindingRoutesByStation("City C");
        thenRoutesAreFound("Route 1", "Route 2");

        whenFindingRoutesByStation("City X");
        thenRoutesAreFound("Route 2");
        thenRoutesAreNotFound("Route 1");

        whenFindingRoutesByStation("City without routes");
        thenRoutesAreNotFound("Route 1", "Route 2");
    }

    private void given(RouteBuilder routeBuilder) {
        this.routeRepository.add(routeBuilder.toRoute());
    }

    private void whenFindingRoutesByStation(String station) {
        this.foundRoutes = this.routeRepository.findByStation(station);
    }
    
    private void thenRoutesAreFound(String... expectedRouteIds) {
        Stream.of(expectedRouteIds).forEach(expectedRouteId -> {
            assertTrue(this.foundRoutes.stream().anyMatch(route -> route.getRouteId().equals(expectedRouteId)));
        });
        
    }
    
    private void thenRoutesAreNotFound(String... unexpectedRouteIds) {
        Stream.of(unexpectedRouteIds).forEach(unexpectedRouteId -> {
            assertTrue(this.foundRoutes.stream().noneMatch(route -> route.getRouteId().equals(unexpectedRouteId)));
        });
        
    }
}
