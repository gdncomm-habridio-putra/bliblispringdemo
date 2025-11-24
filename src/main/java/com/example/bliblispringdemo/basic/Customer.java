package com.example.bliblispringdemo.basic;

import lombok.Data;
import lombok.Getter;

@Getter
public class Customer {

  private int purchaseCount = 0;

  public void increaseCustomerPurchaseCount(){
    purchaseCount ++;
  }
}
