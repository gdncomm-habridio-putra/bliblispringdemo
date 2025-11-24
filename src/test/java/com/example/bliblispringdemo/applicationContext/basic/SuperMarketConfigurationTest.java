package com.example.bliblispringdemo.applicationContext.basic;

import com.example.bliblispringdemo.basic.SuperMarketConfiguration;
import com.example.bliblispringdemo.basic.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SuperMarketConfigurationTest {

  @Test
  void superMarketApplicationContextTest() {
    ApplicationContext superMarketApplicationContext = new AnnotationConfigApplicationContext(
        SuperMarketConfiguration.class);

    Assertions.assertNotNull(superMarketApplicationContext);
  }

  @Test
  void superMarketBeanTest() {
    ApplicationContext superMarketApplicationContext = new AnnotationConfigApplicationContext(
        SuperMarketConfiguration.class);
    Customer customer1 = superMarketApplicationContext.getBean(Customer.class);
    Customer customer2 = superMarketApplicationContext.getBean(Customer.class);

    Assertions.assertEquals(customer1, customer2);
  }

  @Test
  void singletonBeanNotThreadSafe() throws InterruptedException {
    ApplicationContext superMarketApplicationContext = new AnnotationConfigApplicationContext(
        SuperMarketConfiguration.class);

    Customer customer = superMarketApplicationContext.getBean(Customer.class);
    Runnable task = () -> {
      for (int i = 0; i < 1000; i++) {
        customer.increaseCustomerPurchaseCount();
      }
    };

    Thread thread1 = new Thread(task);
    Thread thread2 = new Thread(task);

    thread1.start();
    thread2.start();
    thread2.join();
    thread1.join();

    // expected the result is 2000, but sometimes it's less than 2000
    System.out.println(customer.getPurchaseCount());
  }

  @Test
  void protoTypeBeanTest() {
    ApplicationContext superMarketApplicationContext =
        new AnnotationConfigApplicationContext((SuperMarketConfiguration.class));

    Customer customer1 = superMarketApplicationContext.getBean("prototypeCustomer", Customer.class);
    Customer customer2 = superMarketApplicationContext.getBean("prototypeCustomer", Customer.class);
    Assertions.assertNotEquals(customer1, customer2);
  }

  @Test
  void superMarketDuplicateBeanTest() {
    ApplicationContext superMarketApplicationContext = new AnnotationConfigApplicationContext(
        SuperMarketConfiguration.class);
    Customer customer1 = superMarketApplicationContext.getBean("firstCustomer", Customer.class);
    Customer customer2 = superMarketApplicationContext.getBean("secondCustomer", Customer.class);

    Assertions.assertNotEquals(customer1, customer2);
  }

  @Test
  void superMarketPrimaryBeanTest() {
    ApplicationContext superMarketApplicationContext = new AnnotationConfigApplicationContext(
        SuperMarketConfiguration.class);
    Customer customer1 = superMarketApplicationContext.getBean("firstCustomer", Customer.class);
    Customer customer2 = superMarketApplicationContext.getBean(Customer.class);

    Assertions.assertEquals(customer1, customer2);
  }
}
