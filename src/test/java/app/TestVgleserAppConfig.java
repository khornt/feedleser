package app;

import org.apache.camel.CamelContext;
import org.apache.camel.component.metrics.routepolicy.MetricsRoutePolicyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.sql.DataSource;


@Configuration
@ComponentScan("com.horntvedt.*")
@PropertySource("classpath:application.properties")
public class TestVgleserAppConfig {

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Inject
    CamelContext camelContext;

    @Bean
    @Inject
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void configureCamel() throws Exception {
        camelContext.addRoutePolicyFactory(new MetricsRoutePolicyFactory());
    }




}
