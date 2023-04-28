package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FirstProgramRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer://test?period=5000")
        .setBody(simple("Bem vindo ao projeto!!"))
        .to("log:test");
    }
    
}
