package com.nosbielc.crawler.camelapidb.routers;

import com.nosbielc.crawler.camelapidb.model.PojoParaValidacao;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class PojoValidacaoRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // tag::JsonDataFormat[]
            // Set up a JSON format so we can unmarshal to a POJO
            JsonDataFormat jsonPojoParaValidacao = new JsonDataFormat(JsonLibrary.Jackson);

            // Set the target class that I want to convert the JSON to
            jsonPojoParaValidacao.setUnmarshalType(PojoParaValidacao.class);
        // end::JsonDataFormat[]

        from("direct:pojoValida")
//                .unmarshal(jsonPojoParaValidacao)
                .unmarshal().json(JsonLibrary.Jackson, PojoParaValidacao.class)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("PojoValidacaoRouter.process");
                    }
                })
                .to("bean-validator://x")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("PojoValidacaoRouter.process.bean-validator");
                    }
                })
                .endRest();

    }
}
