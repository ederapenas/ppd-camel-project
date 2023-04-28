package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FileTestingRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file://E:\\camel-files\\input")
        .log("${body}")
        .to("file://E:\\camel-files\\output");
    }
    
}
