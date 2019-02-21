FROM maven as build
COPY pom.xml /tmp/pom.xml
RUN mvn -B -f /tmp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
WORKDIR /build
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/feedback-forms-accounts-0.0.1-SNAPSHOT.jar /feedback-forms-accounts.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/feedback-forms-accounts.jar"]
