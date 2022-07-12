package de.cgabrisch.railjourneyplanner.service.restapi.routes;

import java.util.List;

record RouteDto(String routeId, String fromStation, String toStation, List<String> viaStations) {
}
