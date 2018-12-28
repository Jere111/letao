package com.letao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心
 */

@SpringBootApplication
@EnableEurekaServer
public class LetaoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetaoEurekaApplication.class, args);
    }

}
