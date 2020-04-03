FROM openjdk:latest
ADD target/govtech-assessment-project.jar /tmp/govtech-assessment-project.jar

ENV HOST=0.0.0.0 PORT=8080
EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "/tmp/govtech-assessment-project.jar" ]
