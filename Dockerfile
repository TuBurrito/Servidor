FROM maven:3.9.6-amazoncorretto-17-al2023 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar .

EXPOSE 8081
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]