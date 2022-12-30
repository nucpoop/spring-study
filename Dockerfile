FROM adoptopenjdk:11-jre-hotspot

COPY build/libs/server-0.0.1-SNAPSHOT.jar server.jar

ENTRYPOINT ["java","-jar","server.jar"]