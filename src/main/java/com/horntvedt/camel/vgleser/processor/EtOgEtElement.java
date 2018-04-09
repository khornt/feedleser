package com.horntvedt.camel.vgleser.processor;

import com.horntvedt.camel.vgleser.database.EntryJDBC;
import com.horntvedt.camel.vgleser.dto.VgNyhet;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EtOgEtElement implements Processor  {

    private static final Logger logger = LoggerFactory.getLogger(EtOgEtElement.class);


    @Autowired
    EntryJDBC entryJDBC;

    @Override
    public void process(Exchange exchange) throws Exception {

        VgNyhet vgNyhet = exchange.getIn().getBody(VgNyhet.class);

        int i = entryJDBC.finnesFraFoer(vgNyhet.getId());

        if (entryJDBC.finnesFraFoer(vgNyhet.getId()) == 0) {

            lagreNyheter(vgNyhet);
        }
        else {
            logger.warn("Fant nyhet fra før!!");
        }
    }



    private void lagreNyheter(VgNyhet nyhet) {

        int  j = entryJDBC.leggInnNyhet(nyhet);
        int  k = entryJDBC.updateNyhet(nyhet.getId());

    }



}
