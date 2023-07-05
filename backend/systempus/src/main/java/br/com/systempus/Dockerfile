#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /systempus/backend/systempus
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