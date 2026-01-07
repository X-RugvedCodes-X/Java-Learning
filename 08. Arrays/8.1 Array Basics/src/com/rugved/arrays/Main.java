package com.rugved.arrays;

// import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");

    // * Jackass Arrays
    // int[][] nums = new int[4][];
    // nums[0] = new int[4];
    // nums[1] = new int[2];
    // nums[2] = new int[3];
    // nums[3] = new int[2];

    // Scanner sc = new Scanner(System.in);
    // for (int i = 0; i < nums.length; ++i) {
    //   for (int j = 0; j < nums[i].length; ++j) {
    //     System.out.println("Kindly Enter Numbers of Row " + (i + 1) + " Column " + (j + 1));
    //     nums[i][j] = sc.nextInt();
    //   }
    // }
    // System.out.println("Numbers Stored in Array");
    // System.out.println("--------- Number Are ---------");
    // for (int i = 0; i < nums.length; ++i) {
    //   for (int j = 0; j < nums[i].length; ++j) {
    //     System.out.print(nums[i][j] + " ");
    //   }
    //   System.out.println();
    // }
    // sc.close();

    // // ^ Important Exceptions to Remember
    // // * ArrayOutOfBoundsException
    // // * NegativeArraySizeException

    // // * Though Arrays store homogenous type of data only, we can do something like this:
    // Object[] arr = new Object[3];
    // arr[0] = "Rugved";
    // arr[1] = 21;
    // arr[2] = 25000.00;
    // * Yes the above Syntax is completely Valid because it's the ultimate Object Class which is inherited by default.

    ObjectTypeArray.objectTypeArray();
  }
};