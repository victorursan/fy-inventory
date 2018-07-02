FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/fy-inventory.jar /fy-inventory/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/fy-inventory/app.jar"]
