package com.rugved.arrays;

public class ObjectTypeArray {
  public static void objectTypeArray() {
    Human[] humans = new Human[3];
    humans[0] = new Human(21, "Rugved", false);
    humans[1] = new Human(55, "Hemant", true);
    humans[2] = new Human(53, "Shraddha", true);

    // for (Human obj : humans) {
    //   System.out.println(obj.getName() + " " + obj.getAge() + " " + obj.isMarried());
    // }

    // Human human = new Human();
    // System.out.println(human.getClass().getName()); // * Way to get Name of a Class

    // * Even array in Java under the hood is the Object.

    // Human human = new Human(21, "Rugved",  false);
    // // System.out.println(human.toString()); // * <-- By Default Prints : com.rugved.main.Human@6b95977
    // // ^ After Overriding toString() method
    // System.out.println(human.toString());   // * <-- Prints: Human [ Rugved, 21, false ] (As Expected)

  }
};