package com.rugved.atmapp;

public class InvalidCustomerException extends Exception {    // * Unchecked Exception
  public InvalidCustomerException(String message) {
    super(message);
  }
};