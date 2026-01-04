package com.rugved.interfaces;

interface Demo1 {
  void disp();
};

//! Not Possible, interface cannot implement but can extend an another interface. ❌
// interface Demo2 implements Demo1 {

// };

//* Not Possible, interface cannot implement but can extend an another interface. ✅
interface Demo2 extends Demo1 {
  void show();
  //^ In case, if both the interfaces have same methods then a common implementation given to both of them in the implementing class.
  // void disp();
};

class Alpha implements Demo2 {
  public void disp() {
    System.out.println("Display Method");
  }

  public void show() {
    System.out.println("Show Method");
  }
};

//* Interface having no methods is called tagged interface or markup interface, though it's also an empty interface, the implementation is given at run time and majorly such design if used in Serialization, Deserialization.
// interface Beta {

// };

public class Demo {
  public static void main(String[] args) {
    System.out.println("hello, interfaces in Demo.java !");

    Demo1 d1 = new Alpha();
    d1.disp();

    Demo2 d2 = new Alpha();
    d2.disp();
    d2.show();
  }
}