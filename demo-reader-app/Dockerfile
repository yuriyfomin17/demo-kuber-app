FROM amazoncorretto:17

VOLUME /tmp

COPY target/*.jar demo-reader-app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/demo-reader-app"]