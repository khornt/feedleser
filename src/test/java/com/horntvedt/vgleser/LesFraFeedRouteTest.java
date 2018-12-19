package com.horntvedt.vgleser;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.awaitility.Duration;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.awaitility.Awaitility.await;

public class LesFraFeedRouteTest extends Testbase {

    @Rule
    public WireMockClassRule wireMockClassRule = new WireMockClassRule(wireMockConfig());

    @Test
    public void testerIkkeEnDrit() {
        assert true;
    }


    @Test
    public void skalGiEnLitenHaugMedRaderIBase() throws Exception{

        Duration femtenSekunder = new Duration(15, TimeUnit.SECONDS);
        await().atMost(femtenSekunder);

        Thread.sleep(15000);
        String s = "heisann";

    }




}
