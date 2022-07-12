package de.cgabrisch.railjourneyplanner.service.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlannerServiceTest {

    @Test
    void findsSingleJourneyFromFirstToLastStationOfGivenRoute() {
        given(route("Route 1").from("City A").to("City D").via("City B").via("City C"));
        whenPlanningJourney("City A", "City D");
        thenFinds(journeyPlan().take("Route 1").from("City A").to("City D"));
    }

    private void given(RouteBuilder routeBuilder) {
        
    }

    private void whenPlanningJourney(String fromStation, String toStation) {

    }

    private void thenFinds(JourneyPlanBuilder journeyPlanBuilder) {
        fail("Not yet implemented");
    }

    private RouteBuilder route(String routeId) {
        return new RouteBuilder(routeId);
    }
    
    private JourneyPlanBuilder journeyPlan() {
        return new JourneyPlanBuilder();
    }
}
