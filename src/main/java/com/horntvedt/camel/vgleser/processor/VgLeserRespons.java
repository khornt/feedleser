package com.horntvedt.camel.vgleser.processor;

import com.horntvedt.camel.vgleser.database.EntryJDBC;
import com.horntvedt.camel.vgleser.dto.vgNyhet;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;


@Component
public class VgLeserRespons implements Processor {


    @Autowired
    EntryJDBC entryJDBC;

    private static final String ENTRY = "entry";

    @Override
    public void process(Exchange exchange) throws Exception {

        Document doc = exchange.getIn().getBody(Document.class);
        exchange.getIn().setBody(doc, Document.class);
        String guid = entryJDBC.hentSistlesteFeedEntry();
        NodeList nl = doc.getElementsByTagName(ENTRY);

        List<vgNyhet> nyheter = byggListe(nl, guid);
        lagreNyheter(nyheter);
    }


    private List<vgNyhet> byggListe(NodeList nl, String guid) {

        List<vgNyhet> nyheter = new ArrayList();

        for(int i = 0; i < 100; i++) {

            Element el = (Element) nl.item(i);
            String id = el.getElementsByTagName("id").item(0).getTextContent();

            if (guid.equals(id)) {
                break;
            }
            nyheter.add(byggNyhet(el));
        }

        return nyheter;

    }


    private void lagreNyheter(List<vgNyhet> nyheter) {

        for(int i = nyheter.size()-1; i >  -1; i--) {
            int  j = entryJDBC.leggInnNyhet(nyheter.get(i));
            int  k = entryJDBC.updateNyhet(nyheter.get(i).getId());
        }
    }

    private vgNyhet byggNyhet(Element el) {

        vgNyhet nyhet = new vgNyhet();
        nyhet.setId(el.getElementsByTagName("id").item(0).getTextContent());
        nyhet.setTitle(el.getElementsByTagName("title").item(0).getTextContent());
        nyhet.setLink(el.getElementsByTagName("link").item(0).getTextContent());
        nyhet.setUpdated(el.getElementsByTagName("updated").item(0).getTextContent());
        nyhet.setSummary(el.getElementsByTagName("summary").item(0).getTextContent());

        return nyhet;


    }
}
