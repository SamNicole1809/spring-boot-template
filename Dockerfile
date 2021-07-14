FROM java:8
VOLUME /tmp
COPY template-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 9300
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=9300"]
