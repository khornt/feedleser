package com.horntvedt.vgleser;

import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Inject
    private CamelContext camelContext;

    @Autowired
    DataSource dataSource;


    @PostConstruct
    public void configureCamel() throws Exception {

        System.out.println("DATASOURCE = " + dataSource);
        camelContext.addRoutePolicyFactory(new MetricsRoutePolicyFactory());

    }
}
