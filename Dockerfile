FROM openjdk:8
ADD target/product-info-services-0.0.1-SNAPSHOT.jar product-info-services-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar", "product-info-services-0.0.1-SNAPSHOT.jar"]
