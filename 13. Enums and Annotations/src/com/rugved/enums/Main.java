package com.rugved.enums;

enum Week {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
};

// * Whenever we create Enum, Behind the Scene a Class gets Created and the Constant are been treated as below:

enum Result {
  PASS, FAIL;
  // public static final Result PASS = new Result();
  // public static final Result FAIL = new Result();
  enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
  };

  int marks;
  private Result() {
    System.out.println("Constructor of Enum");
  } 

  public void setMarks(int marks) {
    this.marks = marks;
  }

  public int getMarks() {
    return this.marks;
  }
};

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, enums !");
    // Week week = Week.MONDAY;
    // System.out.println(week);       // * MONDAY
    // int index = Week.THURSDAY.ordinal();
    // System.out.println(index);      // * 3

    // Week[] weekArray = Week.values();
    // for (Week w : weekArray) {
    //   System.out.println(w.ordinal() + ": " + w);
    // }

    Result result = Result.PASS;      // This Object Utilization of Enum already prints the constructor, the number of times the constants are there
    // result.setMarks(44);
    // System.out.println(result.getMarks());
    // ^ The Above Line Prints: 
    // * Constructor of Enum
    // * Constructor of Enum
    // * 44

    // * The Below Statement do the same as Above
    // Result.PASS.setMarks(44);
    // int marks1 = Result.PASS.getMarks();
    // System.out.println(marks1);

    // int marks2 = Result.FAIL.getMarks();
    // System.out.println(marks2);   // * 0   
  }
};