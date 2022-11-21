FROM openjdk:11
Add cursos.jar cursos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/cursos.jar"]