package com.horntvedt.vgleser;


import org.junit.ClassRule;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public abstract class Testbase {


    @ClassRule
    public final static EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @LocalServerPort
    protected String randomServerPort;



//    @Before
//    public void createTestSetup() throws Exception {
//
//        url = "http://localhost:" + randomServerPort;
//
//    }

}

