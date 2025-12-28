package com.rugved.arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayBasics {
  public static void main(String[] args) {
    System.out.println("hello, arrays!");

    //* By Default 0s
    // int[] nums = new int[5];        
    // int[] digits = {1, 2, 3, 4 ,5};
    // printArray(digits);
    // printArray(nums);
    
    //* By Default null (null is a literal and we can cast it into any reference type), Eg. String str = null;
    // String[] arr = new String[4];   
    // System.out.println(arr[0]);

    Scanner sc = new Scanner(System.in);
    // int[] arr = new int[5];
    // try {
    //   System.out.print("Enter Array Elements: ");
    //   for (int i = 0; i < arr.length; i++) {
    //     arr[i] = sc.nextInt();
    //   }
    // } catch (InputMismatchException e) {
    //   System.out.println("[" + e + "]\nPlease enter only integers. ");

    // } finally {
    //   sc.close();
    // }
    // printArray(arr);

    int[][] arr = new int[3][2];
    //* Prints Row Length */
    // System.out.println(arr.length);   
    System.out.println("Enter 2d Array Elements");
    //* Traditional for loop iteration */
    try {
      for (int row = 0; row < arr.length; ++row) {
        for (int col = 0; col < arr[row].length; ++col) {
          arr[row][col] = sc.nextInt();
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Please Enter Integers Only.");
    } finally {
      sc.close();
    }

    //* Range Based For Loop Iteration
    for (int[] row : arr) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }

  static void printArray(int[] arr) {
    // for (int num : arr) 
    //   System.out.print(num + " ");
    // System.out.println();
    System.out.println(Arrays.toString(arr));
  }
};