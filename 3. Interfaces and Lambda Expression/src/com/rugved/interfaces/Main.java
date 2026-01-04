package com.rugved.interfaces;

//* Interface helps to achieve standardization.
//* One Interface can have any number of implementing classes.
//* We cannot create instance / object of an interface.
//* A Class implements an interface using the 'implements' keyword.
//* A Class can implement multiple interfaces.
//* By default all the variables in an interface are public static final.
//* We cannot have constructor in an interface.

interface NormalCalc {
  //* All methods in interface are by default public and abstract 
  void add(int a, int b);   //* public abstract void add(int a, int b);
  void sub(int a, int b);
};

interface AdvanceCalc {
  void mul(int a, int b);
  void div(int a, int b);
}; 
  
class MyCalc1 implements NormalCalc, AdvanceCalc {
  public void add(int a, int b) {
    int result = a + b;
    System.out.println("Result is: " + result);
  } 
  
  public void sub(int a, int b) {
    int result = a - b;
    System.out.println("Result is: " + result);
  }
  
  public void mul(int a, int b) {
    int result = a * b;
    System.out.println("Result is: " + result);
  }

  public void div(int a, int b) {
    if (b == 0) {
      System.out.println("Enter Non Zero Denominator");
      return;
    } 
    else {
      int result = a / b;
      System.out.println("Result is: " + result);
    }
  }
};

@SuppressWarnings("unused")
class MyCalc2 implements NormalCalc, AdvanceCalc {
  public void add(int a, int b) {
    int n1 = a;
    int n2 = b;
    int result = a + b;
    System.out.println("Result is: " + result);
  } 
  
  public void sub(int a, int b) {
    int n1 = a;
    int n2 = b;
    int result = a - b;
    System.out.println("Result is: " + result);
  }

  public void mul(int a, int b) {
    int n1 = a;
    int n2 = b;
    int result = n1 * n2;
    System.out.println("Result is: " + result);
  }

  public void div(int a, int b) {
    int n1 = a;
    int n2 = b;
    if (n2 == 0) {
      System.out.println("Enter Non Zero Denominator");
      return;
    }
    int result = n1 / n2;
    System.out.println("Result is: " + result);
  }
};

class Algebra {
  public void cal(NormalCalc c, int a, int b) {
    c.add(a, b);
    c.sub(a, b);
  }
};

//* If such is the case where class extends and implements both, then always extend first and implement later. We can even implement any number of interfaces.
@SuppressWarnings("unused")
class NewCalc extends MyCalc1 implements NormalCalc, AdvanceCalc {

};

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, interfaces");

    // Calc calc1 = new MyCalc1();
    // calc1.add(4, 44);
    // calc1.sub(4, 44);

    // Calc calc2 = new MyCalc2();
    // calc2.add(3, 33);
    // calc2.sub(3, 33);

    MyCalc1 cal1  = new MyCalc1();
    MyCalc2 cal2  = new MyCalc2();
    Algebra a     = new Algebra();
    a.cal(cal1, 10, 20);
    a.cal(cal2, 10, 20);

  }
};