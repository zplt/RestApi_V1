package com.restapi.restapi;

import com.infobip.spring.data.jpa.EnableExtendedJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableExtendedJpaRepositories
@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}
