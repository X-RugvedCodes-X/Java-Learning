package com.rugved.passportapplication;

public class Passport {
  private String name, city;
  private Integer age;

  public Passport(String name, String city, Integer age) {
    super();
    this.name = name;
    this.city = city;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Passport -> Name: " + this.name + ", Age: " + this.age + ", City: " + this.city;
  }
};