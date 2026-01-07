package com.rugved.oops;

//* In a class whenever we have methods without the body, we must write abstract keyword for them and these are called abstract methods.
//* If any one method also is abstract then decleare the class as abstract too. 
//* We can't create object of abstract class. 
//* If Parent Class is abstract then we must also make the child class abstract.
//* An abstract class can have few methods concrete (method with body). However if one method is abstract, class also must be abstract.
//* We can create reference of abstract class to achieve Polymorphism.
//* Abstract Class can have constructor, however it will be executed by the super() method call of the Child classes.
//* We cannot make constructor as abstract as in constructor by default there is a super() method.
//* A Variable can never be abstract.
//* An Abstract Class cannot be made 'final' because it should be extended to complete it's implementation and as we know final methods to participate in inheritance but we can't override them. Abstract Class participates in Inheritance, hence it's illegal to make abstract class as final.
//* Abstract method can't be final, because abstract method must get overriden in child classes and final methods can't be overriden,
//* To Achieve 100% Abstraction we must use Interface, because in Interface all the methods are abstract.
//* Interface also provides Multiple Inheritance.
//* Abstract Class can have static blocks too, but again it will be executed by the object of child class. 

abstract class Animal {
  public abstract void eat();
  public abstract void crawl();
  abstract public void run();     //* public <-> abstract interchangeble but follow only one convention
};



public class AbstractKeyword {
  public static void main(String[] args) {
    System.out.println("hello, abstract keyword!");
  }
}