package com.rugved.main;

// * Injecting Dependent Object / Dependency into target class is called as Dependency Injection. If this is done through setter then setter Injection and if through constructor then constructor injection.

// * Target Class / Object -> A Class where services of other classes are being used.
// * Example In this Project -> Academy.java

// * Dependency Class / Object -> A Class whose services will be used in Target Class.
// * Example In this Project -> JavaCourse, SpringBootCourse, etc.

// ^ Interview Question - When we perform constructor injection and setter injection at the same time then the last created object will be used which means the setter injection will be used.

// * Here we have performed Inversion of Control, Which means that the responsiblity of Academy.java is transferred to Main.java

import com.rugved.services.JavaCourse;
// import com.rugved.services.SpringBootCourse;

public class Main {
  public static void main(String[] args) {
    System.out.println("Launching Application ...");

    Academy academy = new Academy(new JavaCourse());
    // academy.setCourse(new SpringBootCourse());
    Boolean status = academy.buyTheCourse(2000.00);
    System.out.println(status ? "Course Purchased Successfully." : "Purchased Failure, Something Went Wrong.");
    
  }
};