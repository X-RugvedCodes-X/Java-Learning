package com.rugved.services;

public class DevopsCourse implements ICourse {
  @Override
  public Boolean getTheCourse(Double amount) {
    Boolean status = true;
    System.out.println("DevopsCourse Purchased\nPrice is : " + amount);
    return status;
  }
};