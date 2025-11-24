package com.example.bliblispringdemo.bitly.service.impl;

import com.example.bliblispringdemo.bitly.config.ShortenerArchitectureConfig;
import com.example.bliblispringdemo.bitly.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThirtyTwoBitUrlShortenerServiceImpl implements UrlShortenerService {

  private final ShortenerArchitectureConfig shortenerArchitectureConfig;

  @Override
  public void doShortenerUrl() {
    System.out.println("shortener url will using " + shortenerArchitectureConfig.getThirtyTwoBit());
  }
}
