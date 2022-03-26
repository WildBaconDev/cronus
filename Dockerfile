FROM gradle:7.4.0-jdk11-alpine as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon --stacktrace

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/cronus-0.0.1-SNAPSHOT.jar /app/cronus.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app/cronus.jar"]