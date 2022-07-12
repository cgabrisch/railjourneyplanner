package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.Collections;
import java.util.List;

public class PlannerService {
    private final RouteRepository routeRepository;

    public PlannerService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    
    public List<JourneyPlan> getJourneyPlans(String fromStation, String toStation) {
        // TODO replace dummy implementation
        return Collections.emptyList();
    }
}
