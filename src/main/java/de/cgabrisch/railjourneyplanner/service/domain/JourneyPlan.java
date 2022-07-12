package de.cgabrisch.railjourneyplanner.service.domain;

import java.util.Collections;
import java.util.List;

public class JourneyPlan {
    public static class Section {
        private final String routeId;
        private final String fromStation;
        private final String toStation;
        
        Section(String routeId, String fromStation, String toStation) {
            this.routeId = routeId;
            this.fromStation = fromStation;
            this.toStation = toStation;
        }

        public String getRouteId() {
            return routeId;
        }

        public String getFromStation() {
            return fromStation;
        }

        public String getToStation() {
            return toStation;
        }
    }
    
    private final List<Section> sections;
    
    JourneyPlan(List<Section> sections) {
        this.sections = Collections.unmodifiableList(sections);
    }
    
    public List<Section> getSections() {
        return this.sections;
    }
}
