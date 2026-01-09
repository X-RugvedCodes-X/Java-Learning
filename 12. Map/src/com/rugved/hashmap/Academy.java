package com.rugved.hashmap;

public class Academy {
  
  private Integer id;
  private String courseName;

  public String getCourseName() {
    return this.courseName;
  }

  public int getId() {
    return this.id;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Academy -> id: " + this.id + ", Course Name: " + this.courseName;
  }

  public Academy() {
    super();
  }

  public Academy(Integer id, String courseName) {
    this.id = id;
    this.courseName = courseName;
  }
};