package com.rugved.singleton;

public class Singleton {
    //* Singleton class means which has only one object, to make such classes we must not allow anyone to call the constructor of the class. 
    //* We do this using private access modifier 
  private Singleton() {

  }

  private static Singleton instance;

  public static Singleton getInstance() {
    //* Check Whether 1 object only created or not */
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
};