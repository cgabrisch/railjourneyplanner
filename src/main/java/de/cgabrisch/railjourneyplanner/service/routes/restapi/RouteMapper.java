package de.cgabrisch.railjourneyplanner.service.routes.restapi;

import org.springframework.stereotype.Service;

import de.cgabrisch.railjourneyplanner.service.routes.domain.Route;
import de.cgabrisch.railjourneyplanner.service.routes.domain.RouteBuilder;

@Service
class RouteMapper {
    Route dtoToModel(RouteDto routeDto) {
        RouteBuilder routeBuilder = RouteBuilder.route(routeDto.routeId(), routeDto.fromStation(), routeDto.toStation());
        routeDto.viaStations().forEach(routeBuilder::via);
        
        Route route = routeBuilder.toRoute();
        return route;
    }
}
