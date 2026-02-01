FROM ubuntu:latest
LABEL authors="DELL"

ENTRYPOINT ["top", "-b"]
# ---------- Stage 1 : Build ----------
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# copy all files
COPY . .

# give permission to mvnw
RUN chmod +x mvnw

# build jar (skip tests for faster build)
RUN ./mvnw clean package -DskipTests


# ---------- Stage 2 : Run ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

# copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
