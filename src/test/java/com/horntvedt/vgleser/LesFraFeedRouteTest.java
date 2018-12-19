package com.horntvedt.vgleser;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class LesFraFeedRouteTest extends Testbase {

    @Rule
    public WireMockClassRule wireMockClassRule = new WireMockClassRule(wireMockConfig());

    @Test
    public void testerIkkeEnDrit() {
        assert true;
    }




}
