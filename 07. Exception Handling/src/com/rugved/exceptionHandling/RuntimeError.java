package com.rugved.exceptionHandling;

// * StackOverflowError - A kind of Runtime Error
public class RuntimeError {
  public void alpha() {
    beta();
  }
  public void beta() {
    alpha();
  }
};