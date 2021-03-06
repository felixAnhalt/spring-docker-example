#base java 8
FROM openjdk:8-jdk-alpine
#timezone
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Europe/Berlin /etc/localtime
ENV TZ="Europe/Berlin"
#define vol
VOLUME /tmp
#copy to new jar
COPY target/demoDocker-0.0.1-SNAPSHOT.jar demo.jar
ENV JAVA_OPTS="" \
DOCKER_JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap" \
LANG=en_US.utf8
#Entry with exec
ENTRYPOINT exec java ${JAVA_OPTS} ${DOCKER_JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /demo.jar
#define usergroup with just few to none permissions and add this
RUN addgroup -S app && \
   adduser -S -g app app && \
   chown app:app /${DEPLOYMENT_ARTIFACT}
USER app