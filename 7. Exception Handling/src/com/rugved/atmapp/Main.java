package com.rugved.atmapp;

public class Main {
  public static void main(String[] args) {
    System.out.println("Atm Application");

    Bank bank = new Bank();
    bank.initiate();
  }
};