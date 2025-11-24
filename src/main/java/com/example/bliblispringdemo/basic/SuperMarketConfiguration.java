package com.example.bliblispringdemo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class SuperMarketConfiguration {

  @Bean
  @Primary
  public Customer firstCustomer () {
    return new Customer();
  }

  @Bean
  public Customer secondCustomer () {
    return new Customer();
  }

  @Bean
  @Scope("prototype")
  public Customer prototypeCustomer () {
    return new Customer();
  }

}
