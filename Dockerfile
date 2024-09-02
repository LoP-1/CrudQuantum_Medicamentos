# Etapa de construcción
FROM ubuntu:latest AS build

# Instalar dependencias
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven

# Crear y configurar directorio de trabajo
WORKDIR /app

# Copiar los archivos necesarios
COPY pom.xml .
COPY src src

# Compilar el proyecto
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:21-jdk-slim

# Exponer el puerto
EXPOSE 8080

# Copiar el jar desde la etapa de construcción
COPY --from=build /app/target/botica-0.0.1-SNAPSHOT.jar app.jar

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
