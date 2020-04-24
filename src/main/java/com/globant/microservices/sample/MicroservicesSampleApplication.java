package com.globant.microservices.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.globant.microservices.sample", "com.globant.microservices.sample.repository"})
public class MicroservicesSampleApplication {

  public static void main(String[] args)  {
    SpringApplication.run(MicroservicesSampleApplication.class, args);
  }
}
