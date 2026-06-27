FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/microservices-kafka-demo-billing-0.0.1-SNAPSHOT.jar app.jar
#COPY opentelemetry-javaagent.jar /otel/opentelemetry-javaagent.jar

EXPOSE 8082

ENTRYPOINT ["java", \
"-XX:+UseContainerSupport", \
"-XX:MaxRAMPercentage=75.0", \
"-XX:InitialRAMPercentage=50.0", \
"-jar", \
"app.jar"]