#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /systempus
COPY . .
RUN mvn clean

#
# Package stage
#
#FROM maven:3.8.3-openjdk-17
#WORKDIR C:/Users/User/Desktop/Iniciação Científica/systempus/systempus/backend/systempus
#COPY --from=build /systempus/*.jar /systempus/systempus.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","app.jar"]