package com.rugved.javabasics;

import java.util.Arrays;
import java.util.Scanner;

public class VariableArguments {
  public static void main(String[] args) {
    System.out.println("hello, variable arguments !");
    // varArgs(1, 2, 3, 4, 5, 6);
    // multipleVarArgs(10, 11, 5, 6, 7, 9);
    System.out.print("Enter A Number: ");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();

    boolean ans = isPrime(num);
    System.out.println(ans ? "Prime Number" : "Not A Prime Number");
    sc.close();
  }

  static void varArgs(int ...nums) {
    System.out.println(Arrays.toString(nums));
    // System.out.println(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }

  //* Variable Argument variable must always be in the last
  static void multipleVarArgs(int a, int b, int ...nums) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(Arrays.toString(nums));
  }

  static boolean isPrime(int num) {
    if(num <= 1)
      return false;

    int c = 2;
    while(c * c <= num) {
      if(num % c == 0) {
        return false;
      }
      c++;
    }
    
    // if(c * c > num)
    //   return true;
    // return false;
    return c * c > num;
  }
};