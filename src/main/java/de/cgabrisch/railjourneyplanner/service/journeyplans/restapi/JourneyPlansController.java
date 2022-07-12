package de.cgabrisch.railjourneyplanner.service.journeyplans.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.cgabrisch.railjourneyplanner.service.journeyplans.domain.JourneyPlan;
import de.cgabrisch.railjourneyplanner.service.journeyplans.domain.PlannerService;

@RestController
class JourneyPlansController {

    private final PlannerService plannerService;
    private final JourneyPlansMapper mapper;

    @Autowired
    JourneyPlansController(PlannerService plannerService, JourneyPlansMapper mapper) {
        this.plannerService = plannerService;
        this.mapper = mapper;
    }

    @GetMapping("/journeyplans")
    JourneyPlansDto getJourneyPlans(@RequestParam(name = "from") String fromStation,
            @RequestParam(name = "to") String toStation) {
        List<JourneyPlan> journeyPlans = this.plannerService.getJourneyPlans(fromStation, toStation);

        return mapper.modelToDto(fromStation, toStation, journeyPlans);
    }

}
