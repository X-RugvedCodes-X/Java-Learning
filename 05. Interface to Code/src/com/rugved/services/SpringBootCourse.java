package com.rugved.services;

public class SpringBootCourse implements ICourse {
  @Override
  public Boolean getTheCourse(Double amount) {
    Boolean status = true;
    System.out.println("SpringBoot Course Purchased\nPrice is : " + amount);
    return status;
  }
};