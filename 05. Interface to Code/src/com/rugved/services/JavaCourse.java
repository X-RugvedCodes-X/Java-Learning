package com.rugved.services;

public class JavaCourse implements ICourse {
  @Override
  public Boolean getTheCourse(Double amount) {
    Boolean status = true;
    System.out.println("JavaCourse Purchased\nPrice is : " + amount);
    return status;
  }
};