package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQSenderRoute extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer://test?period:10000")
        .setBody(simple("Bem vindo ao teste !!!"))
        .to("activemq:test-mq");
    }
    
}
