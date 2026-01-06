package com.rugved.lambdaExpression;

// * An interface which has only one method is called Functional interface
// * We can have as many as default methods in a Functional Interface just that the abstract method should only be one
@FunctionalInterface
interface P {
  void show();

  // default void showData() {
  //   System.out.println("Show Data");
  // }

  // String toString();  // * It's already implemented method from the Supreme Object Class, that's why no error here.
};

// class R implements P {
//   public void show() {
//     System.out.println("Implemented show method");
//   }
// };

@FunctionalInterface
interface Calculator {
  int add(int a, int b);
};
