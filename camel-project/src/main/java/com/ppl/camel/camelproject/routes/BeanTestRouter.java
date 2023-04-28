package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class BeanTestRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("timer:bean-test-timer?period=5000")
        .bean("calculator")
        .to("log:bean-test-timer");
    }
    
}


@Component
class Calculator {
    public String add(){
        return "Bem vindo ao metodo de soma!";
    }

    public String sub(){
        return "Bem vindo ao metodo de subtração!";
    }
}