package com.horntvedt.camel.vgleser.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class EtOgEtElement implements Processor  {

    @Override
    public void process(Exchange exchange) throws Exception {

        Object node = exchange.getIn().getBody(Object.class);

        String s = exchange.getContext().getTypeConverter().convertTo(String.class, node);

    }

}
