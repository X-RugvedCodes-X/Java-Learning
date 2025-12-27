package com.rugved.javabasics;

// import java.util.Scanner;

public class ArmstrongNumber {
  public static void main(String[] args) {
    // System.out.print("Enter A Number: ");
    // Scanner sc = new Scanner(System.in);
    // int num = sc.nextInt();

    // boolean ans = isArmstrong(num);
    // System.out.println(ans ? "Armstrong Number" : "Not An Armstrong Number");

    for(int i = 100; i < 1000; ++i) {
      System.out.println(isArmstrong(i) ?  i + " Is An Armstrong Number" : i + " Is Not An Armstrong Number");
    }
    // sc.close();
  }

  static boolean isArmstrong(int num) {
    int originalNum = num, sum = 0;

    while(num > 0) {
      int remainder = num % 10;
      num = num / 10;
      sum = sum + (remainder * remainder * remainder);
    }

    return sum == originalNum;
  }
};