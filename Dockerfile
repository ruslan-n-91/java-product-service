FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app
COPY . .

RUN ./gradlew clean build -x test

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8256