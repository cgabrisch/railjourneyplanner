package de.cgabrisch.railjourneyplanner.service.journeyplans.restapi;

import java.util.List;

record SectionDto(String routeId, String from, String to) {
}

record JourneyPlanDto(List<SectionDto> sections) {
}

record JourneyPlansDto(String journeyFrom, String journeyTo, List<JourneyPlanDto> plans) {
}
