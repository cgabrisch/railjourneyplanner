package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import de.cgabrisch.railjourneyplanner.service.domain.JourneyPlan.Section;

class JourneyPlanBuilder {
    
    static JourneyPlanBuilder journeyPlan() {
        return new JourneyPlanBuilder();
    }
    
    class SectionBuilder {
        private final String routeId;
        private String fromStation;

        private SectionBuilder(String routeId) {
            this.routeId = Objects.requireNonNull(routeId);
        }
        
        SectionBuilder from(String fromStation) {
            this.fromStation = Objects.requireNonNull(fromStation, "fromStation must not be null in section of JourneyPlan");
            
            return this;
        }
        
        JourneyPlanBuilder to(String toStation) {
            Objects.requireNonNull(toStation, "toStation must not be null in section of JourneyPlan");
            Objects.requireNonNull(this.fromStation, "fromStation must not be null in section of JourneyPlan");
            
            Section section = new Section(this.routeId, this.fromStation, toStation);
            JourneyPlanBuilder.this.sections.add(section);
            
            return JourneyPlanBuilder.this;
        }
    }

    private final List<Section> sections = new LinkedList<>();
    
    SectionBuilder take(String routeId) {
        return new SectionBuilder(routeId);
    }

    JourneyPlan toJourneyPlan() {
        return new JourneyPlan(this.sections);
    }
}
