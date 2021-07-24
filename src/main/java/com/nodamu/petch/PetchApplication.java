package com.nodamu.petch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetchApplication
{

    public static void main(String[] args) {
        SpringApplication.run(PetchApplication.class, args);
    }


}
