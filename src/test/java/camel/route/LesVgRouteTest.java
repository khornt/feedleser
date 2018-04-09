package camel.route;

import com.horntvedt.camel.vgleser.VgleserApp;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.List;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = VgleserApp.class)
public class LesVgRouteTest {

    @Inject
    CamelContext camelContext;

    private ProducerTemplate template;


//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(Mocks.SERVER_PORT);

    private List<Request> requests;

    @Before
    public void setup() throws Exception {
        //prepareRouteMocks();
        template = camelContext.createProducerTemplate();
    }


    @Test
    public void skalTaImotAtomFeedOgFinneSistBehandlet() throws Exception {

        Exchange exchange = buildExchangeMedVgFeed();

    }

    private Exchange buildExchangeMedVgFeed() throws Exception {
        Exchange exchange = new DefaultExchange(camelContext);
         //Velocity??
        return exchange;
    }



}
