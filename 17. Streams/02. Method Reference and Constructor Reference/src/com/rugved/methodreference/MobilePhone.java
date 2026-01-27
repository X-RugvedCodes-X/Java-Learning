package com.rugved.methodreference;

public class MobilePhone {
  String name;
  public MobilePhone() {
  }
  public MobilePhone(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return "MobilePhone [name=" + name + "]";
  }
  
}
