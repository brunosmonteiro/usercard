# UserCard API
Project which contains a CRUD API regarding user and user associated cards management.

### Technologies
- Spring Boot 2.5.2
  -- Spring Data JPA, Spring Test, Spring Validator, Spring Actuator, Spring Web, Spring Security.
- Maven 3.8.1
- Java 11
- Docker
- Postgres
- Mapstruct
- Lombok
- Mockito
- Junit5

### Architectural Decisions
The project uses a standard MVC architectural approach, with Controller, Service, Mapper and Repository layers. Dto objects carry all the data that is returned and received from the external world, while the service layer only deals with entity classes.
id to the Dto.

The BaseMapper class automatically loads any entity based on the Dto object's id calling the EntityManager. For example, if a request arrives with {"card": 1}, the mapper has the mechanism to dispatch a select query to the card database searching for an item with the id 1. It also automatically extracts any entity's id to the Dto.

The use of base classes was to avoid duplicate code between user and card entities in the CRUD operations. By doing so, both these entities and any other eventual one with CRUD operations must only extend these classes with no necessity to code unless it has specific rules.

### Running the project
The bash script ./init.sh can be executed to deploy the application on localhost, port 9999. It will:
1. Execute 'mvn clean install' on the base of the project;
2. Generate a docker image based on the Dockerfile;
3. Create a postgres database container, and an API container with the image generated in the previous step.
