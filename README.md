# E-Core Roles Manager
This repository is a submission to E-Core's Back-end developer exercise.
The project runs a REST service that manages the concept of roles for team members and teams, extending the functionality of the users and teams services provided in the exercise.

### Using:
Once running, the following endpoints are exposed on port 8080:
- POST `/roles` 
  - Creates a new role.
```JSON 
{"name": "[role name]"}
```
- POST `/roles/assign` 
  - Assigns a role to a user. This only makes sense within the context of a team, so it must be passed too.
```JSON
{
  "memberId": "[member id]",
  "teamId": "[team id]",
  "roleName": "[role name]"
 }
 ```
- GET `/roles`
  - Look up all the roles.


- GET `/roles/search/?memberId=[memberId]&teamId=[teamId]`
  - Look up the roles that given member has within given team


- GET `/memberships`
    - Look up all memberships.

- POST `/memberships`
    - Creates a new membership, which is the same thing as assigning a role to a user within a team. This endpoint works in the same way as POST `/roles/assign`
```JSON
{
  "memberId": "[member id]",
  "teamId": "[team id]",
  "roleName": "[role name]"
 }
 ```


### Development
#### Dependencies:
- **Spring**: Dependency injection, inversion of control. As requested by PO.
- **Maven**: Project management.
- **Lombok**: Annotations to reduce boilerplate code.
- **OkHttp**: Http client to query from E-Core's existing services.
- **Mongo**: A database chosen for its simplicity.
- **Docker**: Virtualization of containers for ease of deployment. As requested by PO.

#### How I approached the solution:
Given the constraints:
- A Team contains a list of 0 or more Team Members, one of which is the Team Leader
- Each Team Member can be part of zero or more Teams
- A Membership is a Team Member within a Team (That will have one role, "Developer" by default).
And also assuming that:
- A team member can belong to multilple roles in the same team
- A Role is a category for Memberships

Following the Spring framework I organized the project in folders for controllers, services, models and repositories.
Plain models for all entities that would be manipulated by the service are created, as well as REST endpoints to serve the requested operations:
- [1] Create a new Role
- [2] Assign a Role to a Team Member of a Team (creating a Membership)
- [3] Look up Memberships given a Role
- [4] Look up the Role of a given Membership (uniquely identified by a Team Member Id + Team Id )

[1], [2] and [4] were operations that fit under `/role` so they were placed in RoleController
[3] fits under `/membership` so it was put in MembershipController. For ease of use, [2]Assign was
made available in POST /memberships as well as in POST roles/assign

Persistence follows the Repository Pattern and is managed by Spring with interfaces of MongoRepository relative to each model that needs to be persisted.
I'm running mongodb on docker. The connection details of Mongo are placed in the application.properties file.
Business logic was placed in the appropriate Service classes.
Some of the unit tests were written using Diffblue and adjusted as necessary.
I tried to follow the example API given as closely as possible when naming endpoints and field values, but also found sensible to use the word "Member" instead of "User" because it sounds more nice and human.

#### Build and run:
Building and running were done using IntelliJ IDE.

1- Install the dependencies and build the project using Maven

2- Build the Docker image of the project using the Dockerfile

3- Compose the docker container with docker-compose.yaml, which includes the mongo database

#### Docker-only deploy
1- Run the docker-compose.yaml file with docker-compose.

It will download the tag `nemo642/alex-ecore:1` as well as the mongo images used from docker hub and compose the application automatically


#### Suggestions for improvement in the Team and User services:
- Refactor the existing Teams and Roles services to use the new concept of Roles, so "Team Leader" would be a Role.

#### Things left to be done
Due to time constraints some improvements couldn't be implemented:
- Improve tests. Some tests don't cover all edge cases yet. Integration tests fail to load context.
- Use HTTP status codes consistently across all endpoints by building proper ResponseEntity objects.
- Decide and implement a solution for when the data gets deleted, as suggested by the exercise.
- Add validations that depend on the other services (Such as checking if a user is part of a team before assigning a role)
- Write IDE-agnostic run and build commands
