FROM java:8
VOLUME /tmp
ADD amqp-example-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom" \
	SPRING_RABBITMQ_ADDRESSES="amqp://rabbitmq:5672"
# ENTRYPOINT ["java","$JAVA_OPTS","-jar","/app.jar"]
CMD java $JAVA_OPTS -jar /app.jar
