package com.rugved.services;

public class FedEx implements IDeliveryService {
  @Override
  public Boolean deliverTheProduct(Double amount) {
    Boolean status = true;
    System.out.println("Product Delivered through FedEx and Amount paid is: " + amount);
    return status;
  }
};