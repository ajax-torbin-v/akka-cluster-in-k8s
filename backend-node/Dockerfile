FROM eclipse-temurin:21.0.2_13-jdk

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 2552
EXPOSE 8558

ENTRYPOINT ["java", "-jar", "app.jar"]
