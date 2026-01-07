package com.rugved.exceptionHandling;

// import java.io.IOException;

public class Child2 extends Parent {
  // public void work() throws IOException {     // ! This gives error as we cannot declare checked exception if the parent is not declaring any Exception
  // public void work() throws ArithmecticException {     // * Even this is fine, as it is an unchecked exception
  // public void work() throws IOException {     // & This is fine only if Parent throws an Exception
  // public void work() Exception {     // ! This Guves Error as this is Partially Checked Exception, it gives error in all cases

  public void work() {        // * Any Unchecked Exception is Ok but Checked Exception can only be declared if Parent declares Any Checked Exception
    System.out.println("Child2 works hard.");
  }
}