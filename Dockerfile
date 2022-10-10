FROM openjdk:18
VOLUME /tmp
ARG JAR_FILE
COPY target/*.jar work-task.jar
ENTRYPOINT ["java","-jar","/work-task.jar"]