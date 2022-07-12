package de.cgabrisch.railjourneyplanner.service.domain;

import static de.cgabrisch.railjourneyplanner.service.domain.JourneyPlanBuilder.journeyPlan;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {
    private final RouteRepository routeRepository;

    @Autowired
    public PlannerService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<JourneyPlan> getJourneyPlans(String fromStation, String toStation) {
        // TODO find JourneyPlans that require changing routes
        
        return this.routeRepository.findByStation(fromStation).stream()
                .filter(route -> route.getStations().indexOf(fromStation) < route.getStations().indexOf(toStation))
                .map(directRoute -> journeyPlan().take(directRoute.getRouteId()).from(fromStation).to(toStation))
                .map(JourneyPlanBuilder::toJourneyPlan)
                .collect(Collectors.toList());
    }
}
