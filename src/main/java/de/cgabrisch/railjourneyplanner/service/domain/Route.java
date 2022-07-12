package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.Collections;
import java.util.List;

public class Route {
    private final String routeId;
    private final List<String> stations;
    
    public Route(String routeId, List<String> stations) {
        this.routeId = routeId;
        this.stations = Collections.unmodifiableList(stations);
    }

    public String getRouteId() {
        return routeId;
    }

    public List<String> getStations() {
        return stations;
    }
}
