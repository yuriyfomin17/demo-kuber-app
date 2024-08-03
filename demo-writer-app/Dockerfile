FROM amazoncorretto:17

VOLUME /tmp

COPY target/*.jar demo-writer-app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/demo-writer-app"]