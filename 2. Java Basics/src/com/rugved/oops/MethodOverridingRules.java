package com.rugved.oops;

//* While Overrding Methods -> We cannot decrease the visibility of the method, which means public cannot be converted to any other modifier, etc.
//* We can Increase the Visibility of the method though ie. private can be turned to default/protected/public 
//* We cannot change the primitive return type of the method, but if the return type has parent-child (is-A) relationship then we can change the return type from parent to child or vice-versa, Such types are called Co-Varient Return Type.

//! Private Members / Methods of a class are never inherited.

//^ Method Overloading Promotes Compile Time Polymorphism.
//^ Method Overriding Promotes Run Time Polymorphism.
//^ Static Members / Methods participate in Ineheritance, but if we try to override them in the Child Class, then that overriden method will act as a specialized method of the Child Class. This is called Method Hiding. So overriding doesnot happen, instead a new static method for the child is created.

//! Constructors don't participate in Inheritance, their output is due to the super() method call.

class Airplane {

};

class FighterPlane extends Airplane {

};

class Animal {
  public Airplane dance() {
    System.out.println("Animal Dances...");
    Airplane ap = new Airplane();
    return ap;
  }

  public void eat(String food) {
    System.out.println("Animal Eats");
  }
};

class Tiger extends Animal {
  public FighterPlane dance() {   //* Here we changed the return type of the overriden method and its valid as the parent class method and this class method has a is-A relationship. */
    System.out.println("Tiger Dances...");
    FighterPlane fp = new FighterPlane();
    return fp;
  }

  public void eat(String food) {
    System.out.println("Tiger Hunts and Eats");
  }

  public void eat() {   //* This is valid as in Java we have Method Overloading Concept, So method with same name can have different parameters, such methods are called specialized methods of a child class. */
    System.out.println("Tiger Eats Thrice a Day");
  }
};

public class MethodOverridingRules {
  public static void main(String[] args) {
    System.out.println("hello, method overriding !");

  }
}