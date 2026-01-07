package com.rugved.atmapp;

import java.util.Scanner;

public class Atm {
  private int accountNumber = 4545;
  private int password      = 1234;

  int _accountNumber, _password;

  public void takeInput() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Kindly Enter Account Number: ");
    _accountNumber = sc.nextInt();

    System.out.print("Kindly Enter Password: ");
    _password = sc.nextInt();
  }

  public void verifyCredentials() throws InvalidCustomerException {
    if (accountNumber == _accountNumber && password == _password) {
      System.out.println("Proceed To Withdraw Cash");
    } else {
      // System.out.println("Ohho !, Seems Like Legend ? What's Up ??");
      // InvalidCustomerException invalidCustomerException = new InvalidCustomerException();
      // throw invalidCustomerException;
      // throw new InvalidCustomerException("Invalid Credentials");

      InvalidCustomerException invalidCustomerException = new InvalidCustomerException("Invalid Credentials");
      System.out.println(invalidCustomerException.getMessage());
      throw invalidCustomerException;
    }
  }
}