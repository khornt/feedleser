package com.horntvedt.camel.vgleser.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class VgLeserRespons implements Processor {


    private static final String ENTRY = "entry";

    @Override
    public void process(Exchange exchange) throws Exception {

        Object body = exchange.getIn().getBody(Object.class);
        exchange.getIn().setBody(body);

        Document document = exchange.getIn().getBody(Document.class);


        NodeList nl = document.getElementsByTagName(ENTRY);

        String s = exchange.getContext().getTypeConverter().convertTo(String.class, nl);


        exchange.getIn().setBody(nl);




    }
}
