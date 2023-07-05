#
# Build stage
#
FROM maven:4.0.0-openjdk-17 AS build
WORKDIR /systempus
COPY . .
RUN mvn clean package

#
# Package stage
#
#FROM openjdk:17-alpine
#WORKDIR /systempus
#COPY --from=build /systempus/*.jar /systempus/systempus.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]