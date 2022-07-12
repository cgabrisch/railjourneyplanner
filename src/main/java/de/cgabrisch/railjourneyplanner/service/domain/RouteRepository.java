package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class RouteRepository {
    private final Map<String, Route> routesById = new HashMap<>();
    private final Map<String, List<Route>> routesByStation = new HashMap<>();
    
    public void add(Route route) {
        if (this.routesById.containsKey(route.getRouteId())) {
            throw new IllegalArgumentException("Updating a route is currently not supported");
        }

        route.getStations().forEach(station -> {
            List<Route> routesForStation = Optional.ofNullable(this.routesByStation.get(station)).orElseGet(LinkedList::new);
            
            routesForStation.add(route);
            
            this.routesByStation.put(station, routesForStation);
        });
    }
    
    public List<Route> findByStation(String station) {
        return Collections.unmodifiableList(this.routesByStation.getOrDefault(station, Collections.emptyList()));
    }
}
