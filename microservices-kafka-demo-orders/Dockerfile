FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/microservices-kafka-demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", \
"-XX:+UseContainerSupport", \
"-XX:MaxRAMPercentage=75.0", \
"-XX:InitialRAMPercentage=50.0", \
"-jar", \
"app.jar"]