package com.rugved.licenseapp;

import java.util.Scanner;

public class Applicant {
  int age;

  public void takeInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter Your Age: ");
    age = sc.nextInt();
  }

  public void verifyAge() throws UnderAgeException, OverAgeException {
    if (age >= 18 && age <= 60) {
      System.out.println("Proceed With License Application");
    } else if(age < 18) {
      UnderAgeException underAgeException = new UnderAgeException("Hey Kiddo, Your Time Will Come... Wait Till Then"); 
      System.out.println(underAgeException.getMessage());
      throw underAgeException;
    } else {
      OverAgeException overAgeException = new OverAgeException("Hey Kiddo, Your Time Will Come... Wait Till Then"); 
      System.out.println(overAgeException.getMessage());
      throw overAgeException;
    }
  }
}