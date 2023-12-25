
FROM openjdk:11-jre-slim

WORKDIR /app

COPY /out/gestionCatalogue5Gr1_jar/GestionCatalogue5Gr1Application.jar /app/app.jar

EXPOSE 8080

CMD["java","-jar","app.jar"]