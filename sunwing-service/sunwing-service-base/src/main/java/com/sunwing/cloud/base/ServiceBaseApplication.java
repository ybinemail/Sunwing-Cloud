package com.sunwing.cloud.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sunwing")
@SpringBootApplication
@ComponentScan(basePackages = "com.sunwing")
public class ServiceBaseApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceBaseApplication.class, args);
    }
}
