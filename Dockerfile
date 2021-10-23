FROM adoptopenjdk/openjdk11:ubi
ENV DB_URL='jdbc:h2:tcp://localhost/~/yaksa'
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]