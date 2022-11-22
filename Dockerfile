FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/elastic-search-service-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
RUN echo "monitorRoleUser readwrite \
                                        create javax.management.monitor.*,javax.management.timer.* \
                                        unregister" > /opt/app/jmxremote.access
RUN echo "monitorRoleUser pass1" > /opt/app/jmxremote.password
RUN chmod 600 /opt/app/jmxremote.access
RUN chmod 600 /opt/app/jmxremote.password
COPY ${JAR_FILE} app.jar
ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=true -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.port=7085 -Dcom.sun.management.jmxremote.rmi.port=7085 -Djava.rmi.server.hostname=80.87.201.75 -Dcom.sun.management.jmxremote.access.file=/opt/app/jmxremote.access -Dcom.sun.management.jmxremote.password.file=/opt/app/jmxremote.password"
ENTRYPOINT ["java","-jar","app.jar"]