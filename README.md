# A planner for railroad journeys

An application with a simple business purpose: First, add railway routes connecting different stations A, B, C ... . 
Then, query journey plans for travelling from, say, station A to station C.

This application serves as a playground for trying out new language features, concepts, libraries - whatever comes 
to mind.

Currently, the application only consists of a REST backend implemented in Java. To run the backend, check out the project
and run

    mvn spring-boot:run 
Some sample routes are defined as JSON in `src/test/resources`; to add these, run

    curl -X POST http://localhost:8080/routes -H "Content-Type: application/json" --data "@src/test/resources/route1.json" 
for example. To query journey plans for these routes, run

    curl "http://localhost:8080/journeyplans?from=City_X&to=City_B"
    
However, the business capabilities of this planner application are still rather limited. For example, 
it will find only plans when the departure and the arrival station are directly connected by the same railways route. 
In other words, switching routes is not yet supported.
