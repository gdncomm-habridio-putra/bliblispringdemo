package com.example.bliblispringdemo.bitly;

import com.example.bliblispringdemo.bitly.service.UrlShortenerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BitLy {

  @Autowired
  @Qualifier("thirtyTwoBitUrlShortenerServiceImpl")
  private UrlShortenerService urlShortenerService;

}
