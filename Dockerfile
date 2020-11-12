FROM adoptopenjdk/openjdk11:jre
ADD target/telegrambot-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [
    "java"
    , "-Xms128m -Xmx1024m -Dsun.rmi.dgc.client.gcInterval=3600000 -Dsun.rmi.dgc.server.gcInterval=3600000 \
   -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=15005 -Dcom.sun.management.jmxremote \
   -Dcom.sun.management.jmxremote.port=19090 -Dcom.sun.management.jmxremote.rmi.port=19090 \
   -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false \
   -Djava.rmi.server.hostname=127.0.0.1"
   , "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}"
   , "-jar telegrambot-0.0.1-SNAPSHOT.jar"
   , "com.thevoodoohuman.telegrambot.TelegrambotApplication"  
   ]
