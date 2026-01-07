package com.rugved.exceptionHandling;

// * Type of Exceptions which are checked by Compiler are called Checked Exceptions like in the case of Thread.sleep, which means compiler will tell the possiblity that Exception might occur.
// * On the contrary Unchecked Exceptions are such Exceptions whose possibilty Compiler won't tell us, we have to decipher it on our own

public class CheckedAndUncheckedExceptions {
  public static void checkedAndUncheckedException() throws InterruptedException {
    System.out.println("checkedAndUncheckedException thread started");
    Thread.sleep(3000);
    System.out.println("checkedAndUncheckedException thread ended");
  }
};