package com.rugved.interfaceToCode;

import com.rugved.services.ICourse;

public class Academy {
  private ICourse course;

  public Academy() {
    super();
  };

  public Academy(ICourse course) {
    super();
    this.course = course;
  }

  public void setCourse(ICourse course) {
    this.course = course;
  }

  public Boolean buyTheCourse(Double amount) {
    return course.getTheCourse(amount);
  }
}