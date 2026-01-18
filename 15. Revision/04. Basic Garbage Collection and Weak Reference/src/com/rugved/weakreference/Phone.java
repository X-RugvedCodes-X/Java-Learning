package com.rugved.weakreference;

public class Phone {

  private String brand, phoneName;

  Phone(){}
  Phone(String brand, String phoneName) {
    this.brand = brand;
    this.phoneName = phoneName;
  }

  @Override
  public String toString() {
    return "Phone -> [brand=" + brand + ", phoneName=" + phoneName + "]";
  }

}