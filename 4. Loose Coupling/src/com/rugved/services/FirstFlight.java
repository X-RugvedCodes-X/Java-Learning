package com.rugved.services;

public class FirstFlight implements IDeliveryService {
  @Override
  public Boolean deliverTheProduct(Double amount) {
    Boolean status = true;
    System.out.println("Product Delivered through FirstFlight and Amount paid is: " + amount);
    return status;
  }
};