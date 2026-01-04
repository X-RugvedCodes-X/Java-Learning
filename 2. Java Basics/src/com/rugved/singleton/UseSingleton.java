package com.rugved.singleton;

public class UseSingleton {
  public static void main(String[] args) {
    //! Gives Error
    // Singleton obj = new Singleton(); 
    Singleton obj = Singleton.getInstance();
  }
};