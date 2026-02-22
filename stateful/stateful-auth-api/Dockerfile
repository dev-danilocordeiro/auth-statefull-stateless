# ---------- STAGE 1: build ----------
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app

# Copia tudo do projeto
COPY . .

# Permite executar o gradlew
RUN chmod +x gradlew

# Build do jar
RUN ./gradlew clean bootJar --no-daemon


# ---------- STAGE 2: runtime ----------
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]