package de.cgabrisch.railjourneyplanner.service.journeyplans.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
        
        @Override
        public int hashCode() {
            return Objects.hash(fromStation, routeId, toStation);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Section other = (Section) obj;
            return Objects.equals(fromStation, other.fromStation) && Objects.equals(routeId, other.routeId)
                    && Objects.equals(toStation, other.toStation);
        }
    }
    
    private final List<Section> sections;
    
    JourneyPlan(List<Section> sections) {
        this.sections = Collections.unmodifiableList(sections);
    }
    
    public List<Section> getSections() {
        return this.sections;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sections);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JourneyPlan other = (JourneyPlan) obj;
        return Objects.equals(sections, other.sections);
    }
}
