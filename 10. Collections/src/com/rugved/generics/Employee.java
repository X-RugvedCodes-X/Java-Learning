package com.rugved.generics;

public class Employee {
  private Integer id;
  private String name, city;

  public Employee() {
    super();
    this.id = 0;
    this.name = null;
    this.city = null;
  };
  public Employee(Integer id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  @Override
  public String toString(){
    return "Employee: id = " + id + ", name = " + name + ", city = " + city;
  }
};