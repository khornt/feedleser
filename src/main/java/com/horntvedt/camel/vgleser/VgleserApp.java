package com.horntvedt.camel.vgleser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VgleserApp {

    public static void main(String[] args) throws Exception {

        ApplicationContext run = SpringApplication.run(VgleserApp.class, args);

    }
}
