package com.example.bliblispringdemo.introduction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SuperMarketConfigurationTest {

  /**
   * Verifies that the Spring ApplicationContext can be created successfully
   * using {@link SuperMarketConfiguration}.
   * <p>
   * This test demonstrates the most basic Spring concept: starting the IoC
   * container (ApplicationContext) using a Java-based configuration class.
   * <p>
   * If the context is created without errors and is not null, it means:
   * - The configuration class is valid.
   * - Spring's dependency injection container starts correctly.
   * - The application is ready to manage beans.
   */
  @Test
  void testSuperMarketApplicationContext() {
    ApplicationContext superMarketApplicationContext =
        new AnnotationConfigApplicationContext(SuperMarketConfiguration.class);

    Assertions.assertNotNull(superMarketApplicationContext);
  }

}
