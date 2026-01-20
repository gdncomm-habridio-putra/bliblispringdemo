package com.example.bliblispringdemo;

import com.example.bliblispringdemo.bitly.BitLy;
import com.example.bliblispringdemo.bitly.config.ShortenerArchitectureConfig;
import com.example.bliblispringdemo.bitly.service.UrlShortenerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties({ShortenerArchitectureConfig.class})
public class BliblispringdemoApplication {
	public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(BliblispringdemoApplication.class, args);

    BitLy bitLy = applicationContext.getBean(BitLy.class);
    bitLy.getUrlShortenerService().doShortenerUrl();
	} 
}
