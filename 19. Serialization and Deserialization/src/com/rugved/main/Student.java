package com.rugved.main;

import java.io.Serializable;

// * Its a Marker Interface, denoting that classes extending it are allowed to Serialized
public class Student implements Serializable {
  private String name;
  transient private String email;   // * transient keyword is used to make the variable not participate in Serialization Process
  // * Now email=null 
  private int age;
  private String address;
  
  public Student() {
  }
  public Student(String name, String email, int age, String address) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.address = address;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  @Override
  public String toString() {
    return "Student [name=" + name + ", email=" + email + ", age=" + age + ", address=" + address + ", getName()="
        + getName() + ", getEmail()=" + getEmail() + ", getAge()=" + getAge() + ", getAddress()=" + getAddress()
        + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  public void displayName() {
    System.out.println("Hi, My Name is " + this.name);
  }
}
