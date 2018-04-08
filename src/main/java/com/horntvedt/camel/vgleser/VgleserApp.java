package com.horntvedt.camel.vgleser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import javax.sql.DataSource;


@SpringBootApplication
public class VgleserApp {

    public static void main(String[] args) throws Exception {

        ApplicationContext run = SpringApplication.run(VgleserApp.class, args);

    }
}
