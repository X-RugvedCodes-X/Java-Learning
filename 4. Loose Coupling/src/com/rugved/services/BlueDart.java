package com.rugved.services;

public class BlueDart implements IDeliveryService {
  @Override
  public Boolean deliverTheProduct(Double amount) {
    Boolean status = true;
    System.out.println("Product Delivered through BlueDart and Amount paid is: " + amount);
    return status;
  }
};