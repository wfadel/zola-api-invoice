FROM anapsix/alpine-java
MAINTAINER Waseem Fadel
EXPOSE 8080
COPY target/zola-api-invoice-2019.1.0.jar zola-api-invoice-2019.1.0.jar
CMD ["java","-jar","zola-api-invoice-2019.1.0.jar"]
