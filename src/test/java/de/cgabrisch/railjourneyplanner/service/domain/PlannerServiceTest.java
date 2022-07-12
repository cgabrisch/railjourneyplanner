package de.cgabrisch.railjourneyplanner.service.domain;

import static de.cgabrisch.railjourneyplanner.service.domain.JourneyPlanBuilder.journeyPlan;
import static de.cgabrisch.railjourneyplanner.service.domain.RouteBuilder.route;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlannerServiceTest {
    private RouteRepository routeRepository;
    private PlannerService plannerService;
    private List<JourneyPlan> journeyPlans;
    
    @BeforeEach
    void setup() {
        this.routeRepository = new RouteRepository();
        this.plannerService = new PlannerService(this.routeRepository);
        this.journeyPlans = Collections.emptyList();
    }

    @Test
    void findsSingleJourneyFromFirstToLastStationOfGivenRoute() {
        given(route("Route 1", "City A", "City D").via("City B").via("City C"));
        
        whenPlanningJourney("City A", "City D");
        
        thenFinds(journeyPlan().take("Route 1").from("City A").to("City D"));
    }

    @Test
    void doesNotFindReverseJourneyFromLastToFirstStationOfGivenRoute() {
        given(route("Route 1", "City A", "City D").via("City B").via("City C"));
        
        whenPlanningJourney("City D", "City A");
        
        thenFindsNoJourneys();
    }

    @Test
    void findsJourneysForAllDirectRoutesBetweenTwoStations() {
        given(
                route("Route 1", "City A", "City D").via("City B").via("City C"),
                route("Route 2", "City X", "City Y").via("City B").via("City Z").via("City C"));
        
        whenPlanningJourney("City B", "City C");
        
        thenFinds(
                journeyPlan().take("Route 1").from("City B").to("City C"),
                journeyPlan().take("Route 2").from("City B").to("City C"));
    }

    private void given(RouteBuilder... routeBuilders) {
        Stream.of(routeBuilders).forEach(routeBuilder -> this.routeRepository.add(routeBuilder.toRoute()));
    }

    private void whenPlanningJourney(String fromStation, String toStation) {
        this.journeyPlans = this.plannerService.getJourneyPlans(fromStation, toStation);
    }

    private void thenFinds(JourneyPlanBuilder... journeyPlanBuilders) {
        Stream.of(journeyPlanBuilders).forEach(journeyPlanBuilder -> 
            assertTrue(this.journeyPlans.contains(journeyPlanBuilder.toJourneyPlan()))
        );
    }
    
    private void thenFindsNoJourneys() {
        assertTrue(this.journeyPlans.isEmpty());
    }
}
