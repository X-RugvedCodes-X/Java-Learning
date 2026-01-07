package com.rugved.atmapp;

public class Bank {
  public void initiate() {
    Atm atm = new Atm();
    try {
      atm.takeInput();
      atm.verifyCredentials();
    } catch (InvalidCustomerException invalidCustomerException1) {
      System.out.println("Try Again !");
      try {
        atm.takeInput();
        atm.verifyCredentials();
      } catch (InvalidCustomerException invalidCustomerException2) {
      System.out.println("Try Again !");
        try {
          atm.takeInput();
          atm.verifyCredentials();
        } catch (InvalidCustomerException invalidCustomerException3) {
          System.out.println("Hey Legend, Now Fake Off !");
        }
      }
    }
  }
};