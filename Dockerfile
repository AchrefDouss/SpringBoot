
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY out/artifacts/gestionCatalogue5Gr1_jar/gestionCatalogue5Gr1.jar /app/gestionCatalogue5Gr1.jar

# Copy the entrypoint script into the container at /app
COPY entrypoint.sh /app/

# Make the entrypoint script executable
RUN chmod +x /app/entrypoint.sh

# Set environment variables
ENV MYSQL_DATABASE=catalogue5DNI2
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=""
ENV MYSQL_HOST=localhost
ENV MYSQL_PORT=3306

# Expose the port that your application will run on
EXPOSE 8080

# Run the application when the container starts
ENTRYPOINT ["./entrypoint.sh"]


EXPOSE 8888

CMD ["java","-jar","gestionCatalogue5Gr1.jar"]