FROM java:8

COPY /root/demoWorkSpace/code/dream-demo/target/dream-demo-1.0.0.jar /app.jar

CMD ["--server.port=8080"]

ENTRYPOINT ["java","-jar", "/app.jar"]