FROM openjdk:11
EXPOSE 8081
COPY target/eCommerce-1.0.jar eCommerce.jar
ENTRYPOINT ["java","-jar","/eCommerce.jar"]
