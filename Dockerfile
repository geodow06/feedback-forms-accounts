FROM maven as build
WORKDIR /build
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/feedback-forms-accounts.jar /feedback-forms-accounts.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/feedback-forms-accounts.jar"]
