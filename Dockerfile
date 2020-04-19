FROM openjdk:8-jre-alpine
EXPOSE 8080
ADD /target/lorenzo-rest-1.0-SNAPSHOT.jar usersapp.jar
ENTRYPOINT ["java", "-jar", "usersapp.jar"]


