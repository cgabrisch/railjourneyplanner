package de.cgabrisch.railjourneyplanner.service.routes.restapi;

import java.util.List;

record RouteDto(String routeId, String fromStation, String toStation, List<String> viaStations) {
}
