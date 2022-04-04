FROM openjdk:8
WORKDIR /usr/app
COPY build/libs/gpsUtil-1.0.0.jar tourguide-gps.jar
CMD ["java", "-jar", "tourguide-gps.jar"]
EXPOSE 8082