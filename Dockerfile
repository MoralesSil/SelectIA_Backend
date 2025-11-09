FROM eclipse-temurin:21-jdk
VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE=target/SelecIA_Backend-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} SelecIA_Backend.jar

ENTRYPOINT ["java","-jar","/SelecIA_Backend.jar"]
