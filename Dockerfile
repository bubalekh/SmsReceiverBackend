# build
FROM maven:3-eclipse-temurin-18 AS builder
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn -B -e -T 1C -C org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline
COPY . .
RUN mvn -B -e -T 1C verify
RUN mvn -B -e -T 1C clean package spring-boot:repackage
RUN mvn clean package spring-boot:repackage

# runtime
FROM eclipse-temurin:18-jre AS runtime
RUN addgroup --system app && \
    adduser --system --home /opt/app --ingroup app app
WORKDIR /opt/app
COPY --from=builder --chown=app:app /usr/src/app/target/*.jar /opt/app/app.jar
USER app:app
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]
