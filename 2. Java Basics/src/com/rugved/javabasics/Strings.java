package com.rugved.javabasics;

public class Strings {
  public static void main(String[] args) {
    System.out.println("hello, strings");

    //* 1st Initialization technique
    // String name = new String("Rugved");
    // System.out.println("hello " + name);

    //* 2nd Initialization technique
    // String myName = "Rugved";
    // myName = myName + " Raorane";
    // System.out.println("hello, " + myName);

    String s1 = "Rugved";
    String s2 = s1;

    s2 = s2 + " Raorane";
    System.out.println(s1);
    System.out.println(s2);
  }
};