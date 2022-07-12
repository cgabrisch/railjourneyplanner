package de.cgabrisch.railjourneyplanner.service.restapi.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.cgabrisch.railjourneyplanner.service.domain.Route;
import de.cgabrisch.railjourneyplanner.service.domain.RouteRepository;

@RestController
class RoutesController {
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;
    
    @Autowired
    RoutesController(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    @PostMapping("/routes")
    void addRoute(@RequestBody RouteDto routeDto) {
        Route route = this.routeMapper.dtoToModel(routeDto);
        this.routeRepository.add(route);
    }
}
