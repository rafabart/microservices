FROM openjdk:11
VOLUME /tmp
ADD ./build/libs/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]