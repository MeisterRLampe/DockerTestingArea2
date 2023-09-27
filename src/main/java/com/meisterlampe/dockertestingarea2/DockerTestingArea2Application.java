package com.meisterlampe.dockertestingarea2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DockerTestingArea2Application {

    public static void main(String[] args) {
        SpringApplication.run(DockerTestingArea2Application.class, args);
    }

}
