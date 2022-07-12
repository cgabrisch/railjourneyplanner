package de.cgabrisch.railjourneyplanner.service.domain;

public class RouteBuilder {
    private final String routeId;

    public RouteBuilder(String routeId) {
        this.routeId = routeId;
    }

    public RouteBuilder from(String station) {
        return this;
    }

    public RouteBuilder to(String station) {
        return this;
    }

    public RouteBuilder via(String station) {
        return this;
    }
    
}
