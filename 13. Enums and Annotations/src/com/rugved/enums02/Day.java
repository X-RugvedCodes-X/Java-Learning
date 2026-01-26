package com.rugved.enums02;

public enum Day {
  // * Check At Compile Time.png
  SUNDAY("Sunday"), 
  MONDAY("Monday"), 
  TUESDAY("Tuesday"), 
  WEDNESDAY("Wednesday"), 
  THURSDAY("Thursday"), 
  FRIDAY("Friday"), 
  SATURDAY("Saturday");

  private String lower;
  private Day(String lower) {
    this.lower = lower;  
  }
  public String getLower() {
    return lower;
  }
  public String display() {
    return "Today is " + this.name();
  }

};