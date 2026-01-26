package com.rugved.enums01;

public enum Day {
  // * Check At Compile Time.png
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

  public String display() {
    return "Today is " + this.name();
  }
};