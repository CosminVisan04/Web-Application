# Build jar stage
FROM gradle:7.3.3-jdk17 as build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src
RUN gradle build -x test

# Run stage
FROM openjdk:17
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/backend-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]