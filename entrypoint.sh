#!/bin/bash

# Wait for MySQL to be ready
until nc -z -v -w30 $MYSQL_HOST $MYSQL_PORT; do
  echo "Waiting for MySQL to be ready..."
  sleep 5
done

echo "MySQL is ready! Starting the Spring Boot application."

# Run the Spring Boot application
java -jar your-spring-boot-app.jar
