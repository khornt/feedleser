package com.horntvedt.camel.vgleser;

import javax.inject.Inject;
import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;

import javax.annotation.PostConstruct;

@SpringBootConfiguration
@ComponentScan({"com.horntvedt.camel.*"})
public class ApplicationConfig {

    @Inject
    private CamelContext camelContext;

    @Bean
    public ServletRegistrationBean soapDispatchServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");

    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @PostConstruct
    public void configureCamel() throws Exception {
        camelContext.setStreamCaching(true);
        camelContext.addRoutePolicyFactory(new MetricsRoutePolicyFactory());
        //camelContext.getTypeConverterRegistry().addTypeConverters(new KontaktSkatteetatenConverter());

    }




}
