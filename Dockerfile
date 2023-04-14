FROM openjdk:18
COPY target/weatherapi-0.0.1-SNAPSHOT.jar weatherapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/weatherapi-0.0.1-SNAPSHOT.jar"]