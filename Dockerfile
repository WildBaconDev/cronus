FROM gradle:7.4.0-jdk11-alpine as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon --stacktrace

FROM openjdk:11-jre-slim
RUN mkdir /app
RUN /bin/bash -c 'echo ${MONGODB_URI}'
COPY --from=build /home/gradle/src/build/libs/cronus-0.0.1-SNAPSHOT.jar /app/cronus.jar
#ADD ./build/libs/cronus-0.0.1-SNAPSHOT.jar /app/cronus.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod","-jar","/app/cronus.jar"]

#FROM openjdk:11-jre-slim
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-DMONGODB_URI=$MONGODB_URI", "-jar","/app.jar"]


#FROM debian
#ENV N_PORT=${PORT}
#ENV N_MONGODB_URI=$MONGODB_URI
#ENV N_JWT_SECRET=$JWT_SECRET
#ENTRYPOINT ["printenv", "N_PORT", "N_MONGODB_URI", "N_JWT_SECRET"]