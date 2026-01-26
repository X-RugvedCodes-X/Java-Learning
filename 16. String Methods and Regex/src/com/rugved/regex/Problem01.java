package com.rugved.regex;

import java.util.Scanner;

// * Alphanumeric Characters Only: [a-zA-Z0-9]+
// * 10 Digits Only: [0-9]{10}
// * Regex to Match Email Address: ^[a-zA-Z0-9_.$-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$
// * Regex to Match Username Matching numbers, letters and @,$ only: ^[0-9a-zA-Z@$]+$

public class Problem01 {
  public static void problem01() {
    System.out.println("Enter Regular Expression: ");
    Scanner sc = new Scanner(System.in);
    String regex = sc.nextLine();
    System.out.println("Enter Your String: ");
    String str = sc.nextLine();
    sc.close();
    if(str.isBlank() == true) {
      System.out.println("Don't Enter Blank String");
      return;
    }
    str = str.trim();
    boolean result = InputChecker.checkStringAgainstRE(regex, str);
    System.out.println(result);
  }
}
