package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
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

    private void given(RouteBuilder routeBuilder) {
        this.routeRepository.add(routeBuilder.toRoute());
    }

    private void whenPlanningJourney(String fromStation, String toStation) {
        this.journeyPlans = this.plannerService.getJourneyPlans(fromStation, toStation);
    }

    private void thenFinds(JourneyPlanBuilder journeyPlanBuilder) {
        Assertions.assertTrue(this.journeyPlans.contains(journeyPlanBuilder.toJourneyPlan()));
    }

    private RouteBuilder route(String routeId, String fromStation, String toStation) {
        return new RouteBuilder(routeId, fromStation, toStation);
    }
    
    private JourneyPlanBuilder journeyPlan() {
        return new JourneyPlanBuilder();
    }
}
