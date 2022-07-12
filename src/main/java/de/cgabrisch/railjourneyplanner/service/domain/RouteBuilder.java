package de.cgabrisch.railjourneyplanner.service.domain;

import static java.util.Objects.requireNonNull;

import java.util.LinkedList;
import java.util.List;

public class RouteBuilder {
    private final String routeId;
    private final String fromStation;
    private final String toStation;
    private final List<String> viaStations;

    public RouteBuilder(String routeId, String fromStation, String toStation) {
        this.routeId = requireNonNull(routeId);
        this.fromStation = requireNonNull(fromStation);
        this.toStation = requireNonNull(toStation);
        this.viaStations = new LinkedList<>();
    }

    public RouteBuilder via(String station) {
        viaStations.add(requireNonNull(station));
        
        return this;
    }
    
    public Route toRoute() {
        List<String> stations = new LinkedList<>();
        stations.add(fromStation);
        stations.addAll(viaStations);
        stations.add(toStation);

        return new Route(routeId, stations);
    }
}
