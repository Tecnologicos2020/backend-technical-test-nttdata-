FROM maven:3.9.6-eclipse-temurin-17
#COPY /target/*.jar /usr/share/app.jar
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/share/app.jar
ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]
#ENV SPRING_PROFILES_ACTIVE="local"