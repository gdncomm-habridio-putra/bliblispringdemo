package com.example.bliblispringdemo.bitly.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("architecture")
public class ShortenerArchitectureConfig {
  public String thirtyTwoBit;
  public String sixtyFourBit;
}
