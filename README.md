# amqp-example
example of a very simple amqp 'sender' &amp; 'receiver' using Spring Boot

the idea hear is to start a rabbitmq server in a Docker container & connect this "client" to it.
this 'client' acts as the sender & receiver.

(on Ubuntu)
# starting rabbitmq server as Docker container
> docker run -p 5672:5672 -p 15672:15672 rabbitmq:3-management
Note: not running as deamon b/c want to see if/when 'client' connects to it
Note: also included the management plugins so can see the gui at localhost:15672

# starting the 'client' using maven from amqp-example root directory
> mvn spring-boot:run

if all goes well, should see something like this:
...
2015-10-12 11:02:28.675  INFO 10832 --- [lication.main()] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
Listener starting ...
2015-10-12 11:02:28.699  INFO 10832 --- [lication.main()] o.s.a.r.l.SimpleMessageListenerContainer : Consumers are already running
EventHandler says: Hello world - FROM Sender 
... Listener stopping.
2015-10-12 11:02:29.715  INFO 10832 --- [lication.main()] o.s.a.r.l.SimpleMessageListenerContainer : Waiting for workers to finish.
2015-10-12 11:02:29.727  INFO 10832 --- [lication.main()] o.s.a.r.l.SimpleMessageListenerContainer : Successfully waited for workers to finish.
...
