package com.ppl.camel.camelproject.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EIPMulticastPipelineRouter extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet");

        rest("/payment")
        .get()
        .to("direct:payment-completed");

        from("direct:payment-completed")
        .setBody().constant("Pagamento da sua compra online completo. Obrigado!")
        .pipeline()
        .multicast()
        .parallelProcessing()
        .to("direct:sender-bank-system")
        .to("direct:receiver-bank-system")
        .to("direct:online-shopping-system");


        from("direct:sender-bank-system")
        .setBody().constant("O Enviador está enviando o dinheiro, saldo a ser enviado: 20,00 reais. Saldo atual: 500,00 reais.")
        .log("${body}...${threadName}");

        from("direct:receiver-bank-system")
        .setBody().constant("O Receptor recebeu o dinheiro, saldo adicionado: 20,00 reais, saldo atual: 220,00 reais")
        .log("${body}...${threadName}");

        from("direct:online-shopping-system")
        .setBody().constant("Transação realizada.")
        .log("${body}...${threadName}");
    }

}