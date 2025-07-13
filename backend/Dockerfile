FROM openjdk:24 AS build

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B


COPY src ./src


#tests are run here
RUN ./mvnw clean package


FROM openjdk:24

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]