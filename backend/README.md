# Pet Store
This is a SpringBoot application where the methods are implemented to be used as REST endpoints, and there is also GraphQL support in addition to REST which runs on its own mutations/querries in seperate controllers, packaged within web/graphql. Users can create/add pets to the store or buy pets from the store. 

## Assumptions made during development:
- Budget field within the User model and price within Pet should be objects of a seperate class(Money).
- Users have no field for pet while in pet there is a foreign key pointing to user(User owner).
- Owner within Pet should have eager loading for hibernate to resolve it and have it show up in the endpoint at the cost of performance.
- Rating is not a seperate class but instead an integer.
- Cat/Dog should be an enumeration(Type).
- Buy method should be within the user model and take Pet as an argument, so we can easily set the pets owner to "this".
- Making a method using JPARepository to find a pet without owner will make the buy method easier to implement with cleaner code (findFirstByOwnerIsNullOrderById).
- Creating random users and pets - instead of using a for cycle and naming users from 1-10 used the Datafaker dependency to generate fake information. (https://www.datafaker.net/documentation/getting-started/).

## Running the application(requires java version 24)
To run the application it can be done by running PetStoreApplication's main method or running ./mvnw spring-boot:run in the terminal from the root project directory.

## Running the application with Docker
In case there are dependency problems and the application won't run, you can start the app as a docker container.
- Pull the docker image with ```docker pull dimitarxz/petstore-app:1.0```
- Run the docker image with ```docker run -p 8080:8080 dimitarxz/petstore-app:1.0```(or another host-side port which isn't in use)

## Database
The database it is running on by default is h2 and can be accessed on localhost:8080/h2-console with no setup needed with the following credentials
- JDBC URL: jdbc:h2:mem:petstore
- Username: sa
- Password: password

To start the application with PostgreSQL as the database, the commented out PostgreSQL properties in application.properties should be uncommented and the marked h2 properties should be commented, setting the username and password to a local user, and creating a database.
(this is not possible if running the application with the docker image pulled from dockerhub)

## API endpoints:
- POST localhost:8080/api/create-users - Creates 10 users with initialized values 
- GET localhost:8080/api/list-users - Lists all created users
- POST localhost:8080/api/create-pets - Creates 20 pets(10 cats/10 dogs) with initialized values
- GET localhost:8080/api/list-pets - Lists all created pets
- POST localhost:8080/api/buy - Matches a pet with no owner and gives it to a user until all users get a pet. Running this will keep buying pets for users until there are no more pets or the users run out of budget.
- GET localhost:8080/api/history - Lists all buy attempts made with their date and time, successful purchases and failed purchases. 

## GraphQL

GraphQL functionalities can be accessed on localhost:8080/graphiql

Query:
- listPets
- listUsers
- historyLogs

Mutations:
- createPets
- createUsers
- buy

## Tests:
All the tests can be ran by executing ./mvnw test in the terminal.<br>
If the application is ran with Docker, the tests are done during the building of the image. If a test fails, the image won't be built.




