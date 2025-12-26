package com.rugved.oops;

class Loan {

  private int principal, years;
  private double simpleIntrest;
  static  double rateOfInterest;
  static  double denominator;

  static {
    rateOfInterest  = 2.5;
    denominator     = 100.0;
  }

  Loan(int principal, int years) {
    super();
    this.principal = principal;
    this.years = years;
  }

  public void calculateSimpleIntrest() {
    simpleIntrest = this.principal * rateOfInterest * this.years / denominator;
  }

  public void displaySimpleIntrest() {
    System.out.println("SimpleIntrest is: " + simpleIntrest);
  }

}

public class FarmerLoanApplication {
  public static void main(String[] args) {
    Loan l1 = new Loan(10000, 2);
    Loan l2 = new Loan(20000, 1);

    l1.calculateSimpleIntrest();
    l1.displaySimpleIntrest();

    l2.calculateSimpleIntrest();
    l2.displaySimpleIntrest();
  }
}