package com.rugved.oops;

class PersonA { //* extends Object Class by Default */
  static {
    System.out.println("Static Person A");
  }
  int age;
  PersonA() {
    System.out.println("Default Constructor [PERSON_A]");
  }
  void display() {
    age = 10;
    System.out.println("Person is " + age + " year old.");
  }
}

class PersonB extends PersonA {
  //* Here By Default a Default Constructor is present, */
  //* So When we do PersonB p1 = new Person(); we still see the output as Default Constructor [PERSON_A] because*/
  //* PersonB() {
  //*   super(); // It Happens due the Super method call which triggers the default constructor of the Parent Class (PersonA here).    
  //*}

  static {
    System.out.println("Static Person B");
  }

  void running() {
    System.out.println("Person Runs");
  }
}

//^ Multiple Inheritance is not allowed in Java, which means one child class cannot have multiple parent classes.

public class Inheritance {
  public static void main(String[] args) {
    PersonA p1 = new PersonA();
    p1.display();

    PersonA p2 = new PersonB();   //* Upcasting   - Child Type -> Parent Type
    ((PersonB) p2).running();     //* Downcasting - Changing Parent type reference to Child type to access Specialized behaviour of Child.    
    p2.display();
  }
}