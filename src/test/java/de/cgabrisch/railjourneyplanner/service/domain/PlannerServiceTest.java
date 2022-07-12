package de.cgabrisch.railjourneyplanner.service.domain;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlannerServiceTest {
    private RouteRepository routeRepository;
    
    @BeforeEach
    void setup() {
        this.routeRepository = new RouteRepository();
    }

    @Test
    void findsSingleJourneyFromFirstToLastStationOfGivenRoute() {
        given(route("Route 1", "City A", "City D").via("City B").via("City C"));
        whenPlanningJourney("City A", "City D");
        thenFinds(journeyPlan().take("Route 1").from("City A").to("City D"));
    }

    private void given(RouteBuilder routeBuilder) {
        this.routeRepository.add(routeBuilder.toRoute());
    }

    private void whenPlanningJourney(String fromStation, String toStation) {

    }

    private void thenFinds(JourneyPlanBuilder journeyPlanBuilder) {
        fail("Not yet implemented");
    }

    private RouteBuilder route(String routeId, String fromStation, String toStation) {
        return new RouteBuilder(routeId, fromStation, toStation);
    }
    
    private JourneyPlanBuilder journeyPlan() {
        return new JourneyPlanBuilder();
    }
}
