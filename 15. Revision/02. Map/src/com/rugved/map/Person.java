package com.rugved.map;

import java.util.Objects;

public class Person {

  private String name;
  private int id;

  public Person(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "Person -> Name: " + this.name + ", Id: " + this.id;
  }

  @Override
  public boolean equals(Object p) {
    if(this == p) {
      return true;
    } 
    if(p == null) {
      return false;
    }
    if(getClass() != p.getClass()) {
      return false;
    }
    Person otherPerson = (Person) p;
    return this.id == otherPerson.getId() && Objects.equals(this.name, otherPerson.getName());    // * Objects class is used to check nullpointerException
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.id);
  }
}