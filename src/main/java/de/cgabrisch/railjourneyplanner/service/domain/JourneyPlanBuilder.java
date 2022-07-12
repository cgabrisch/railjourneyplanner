package de.cgabrisch.railjourneyplanner.service.domain;

public class JourneyPlanBuilder {
    public class SectionBuilder {
        private final String routeId;

        public SectionBuilder(String routeId) {
            this.routeId = routeId;
        }
        
        public SectionBuilder from(String station) {
            return this;
        }
        
        public JourneyPlanBuilder to(String station) {
            return JourneyPlanBuilder.this;
        }
    }

    public SectionBuilder take(String routeId) {
        return new SectionBuilder(routeId);
    }

}
