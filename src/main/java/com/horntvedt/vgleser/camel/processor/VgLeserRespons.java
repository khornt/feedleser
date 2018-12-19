package com.horntvedt.vgleser.camel.processor;

import com.horntvedt.vgleser.database.EntryJDBC;
import com.horntvedt.vgleser.dto.VgNyhet;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;


@Component
public class VgLeserRespons implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(VgLeserRespons.class);

    @Autowired
    EntryJDBC entryJDBC;

    private static final String ENTRY = "entry";

    @Override
    public void process(Exchange exchange) throws Exception {

        Document doc = exchange.getIn().getBody(Document.class);
        exchange.getIn().setBody(doc, Document.class);
        String guid = entryJDBC.hentSistlesteFeedEntry();
        NodeList nl = doc.getElementsByTagName(ENTRY);

        List<VgNyhet> nyheter = byggListe(nl, guid);

        exchange.getIn().setBody(nyheter, List.class);

    }


    private List<VgNyhet> byggListe(NodeList nl, String guid) {

        List<VgNyhet> nyheter = new ArrayList();

        for(int i = 0; i < 100; i++) {

            Element el = (Element) nl.item(i);
            String id = el.getElementsByTagName("id").item(0).getTextContent();

            if (guid.equals(id)) {
                break;
            }
            nyheter.add(byggNyhet(el));

            if (i == 99) {
                logger.warn("Lestinn fullt sett!: " + i+1 + " nyheter");
            }
        }

        return nyheter;
    }


    private VgNyhet byggNyhet(Element el) {

        VgNyhet nyhet = new VgNyhet();
        nyhet.setId(el.getElementsByTagName("id").item(0).getTextContent());
        nyhet.setTitle(el.getElementsByTagName("title").item(0).getTextContent());
        nyhet.setLink(el.getElementsByTagName("link").item(0).getTextContent());
        nyhet.setUpdated(el.getElementsByTagName("updated").item(0).getTextContent());
        nyhet.setSummary(el.getElementsByTagName("summary").item(0).getTextContent());

        return nyhet;


    }


}
