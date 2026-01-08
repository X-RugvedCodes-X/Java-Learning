package com.rugved.generics;

public class CustomClassForGenerics<T> implements IGenerics<T> {
  private T referenceValue;

  public CustomClassForGenerics(T referenceValue) {
    this.referenceValue = referenceValue;
  }

  public void displayType() {
    System.out.println("Type: " + referenceValue.getClass().getName());    // * Prints (Example) - Type: java.lang.Integer
  }

  public T getReference() {
    return this.referenceValue;
  }

  @Override
  public String toString() {
    return "Type Of Generic Is: " + referenceValue.getClass().getName() + ", Value is: " + this.referenceValue;
  }
};