#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /systempus
COPY . .
RUN mvn clean package

#
# Package stage
#
FROM openjdk:17-alpine
COPY --from=build /systempus/target/systempus.jar systempus.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","systempus.jar"]