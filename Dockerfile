
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY out/artifacts/gestionCatalogue5Gr1_jar/gestionCatalogue5Gr1.jar /app/gestionCatalogue5Gr1.jar

EXPOSE 8080

CMD ["java","-jar","gestionCatalogue5Gr1.jar"]