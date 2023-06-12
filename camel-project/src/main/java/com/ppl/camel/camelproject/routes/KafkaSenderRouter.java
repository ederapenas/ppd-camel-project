package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer://test-kafka?period=10000")
        .setBody(simple("Bem vindo aos testes de Kafka"))
        .to("kafka:myKafkaTopic");
    }
    
}
