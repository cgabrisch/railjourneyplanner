package de.cgabrisch.railjourneyplanner.service.journeyplans.restapi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.cgabrisch.railjourneyplanner.service.journeyplans.domain.JourneyPlan;

@Service
class JourneyPlansMapper {
    JourneyPlansDto modelToDto(String fromStation, String toStation, List<JourneyPlan> journeyPlans) {
        List<JourneyPlanDto> planDtos = journeyPlans.stream().map(plan -> {
            List<SectionDto> sectionDtos = plan.getSections().stream().map(
                    section -> new SectionDto(section.getRouteId(), section.getFromStation(), section.getToStation()))
                    .collect(Collectors.toList());
            
            return new JourneyPlanDto(sectionDtos);
        }).collect(Collectors.toList());
        
        return new JourneyPlansDto(fromStation, toStation, planDtos);
    }
}
