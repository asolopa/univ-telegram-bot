FROM adoptopenjdk/openjdk11:jre
ADD target/telegrambot-0.0.1-SNAPSHOT.jar .
ARG JASYPT_ENCRYPTOR_PASSWORD
ENV JASYPT_ENCRYPTOR_PASSWORD=$JASYPT_ENCRYPTOR_PASSWORD
EXPOSE 19090 15005
ENTRYPOINT  java -Xms128m -Xmx1024m -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000\
                    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=15005 -Dcom.sun.management.jmxremote\
                    -Dcom.sun.management.jmxremote.port=19090 -Dcom.sun.management.jmxremote.rmi.port=19090\
                    -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false\
                    -Djava.rmi.server.hostname=127.0.0.1 -jar telegrambot-0.0.1-SNAPSHOT.jar -Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}