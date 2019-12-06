FROM openjdk:12

VOLUME /tmp

ADD ./target/st-microservice-filemanager-0.0.1-SNAPSHOT.jar st-microservice-filemanager.jar

EXPOSE 8080

ENTRYPOINT java -jar /st-microservice-filemanager.jar