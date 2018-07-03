package com.github.ideal.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot 启动类
 *
 * @author junliang
 */
@RestController
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @GetMapping
    public String root(){
        return "Hello Is Provider!";
    }
}