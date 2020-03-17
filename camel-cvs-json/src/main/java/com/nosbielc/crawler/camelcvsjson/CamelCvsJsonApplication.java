package com.nosbielc.crawler.camelcvsjson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamelCvsJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelCvsJsonApplication.class, args);
    }

    @Bean
    CommandLineRunner timeout() {
        return args -> {
            Thread.sleep(999000);
        };
    }

}
