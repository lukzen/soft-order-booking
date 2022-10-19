FROM openjdk:slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
COPY  application_default_credentials.json creds.json
ENV GOOGLE_APPLICATION_CREDENTIALS=creds.json
ENTRYPOINT ["java","-jar","/app.jar"]