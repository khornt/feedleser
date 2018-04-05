package com.horntvedt.camel.vgleser;

import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Configuration
@ComponentScan({"com.horntvedt.*"})
public class ApplicationConfig {

    @Inject
    private CamelContext camelContext;

//    @Bean
//    public ServletRegistrationBean soapDispatchServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
//
//    }
//
//    @Bean(name = Bus.DEFAULT_BUS_ID)
//    public SpringBus springBus() {
//        return new SpringBus();
//    }

    @PostConstruct
    public void configureCamel() throws Exception {

        camelContext.addRoutePolicyFactory(new MetricsRoutePolicyFactory());

    }



}
