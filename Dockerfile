#FROM eclipse-temurin:17-jre-alpine
#WORKDIR ./app
#COPY ./out/artifacts/iternship_jar/iternship.jar ./app/iternship.jar
##target/docker-spring-boot-postgres-1.0.0.jar .
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","./app/iternship.jar"]
#FROM maven:3.9.0 as builder
#WORKDIR /app
#COPY . /app/.
#RUN mvn -f ./pom.xml clean package -Dmaven.test.skip=true
#
#FROM eclipse-temurin:17-jre-alpine
#WORKDIR /app
#COPY --from=builder /app/target/*.jar /app/*.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "/app/*.jar"]
FROM maven:3.8.3-openjdk-17 AS MVN_BUILD

COPY ./ ./

RUN mvn clean package

FROM openjdk:17

COPY --from=MVN_BUILD ./target/internship.jar /internship.jar

CMD ["java", "-jar", "/internship.jar"]