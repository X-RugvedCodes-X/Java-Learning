package com.rugved.strings;

public class SomeOtherStringMethods {
  public static void someOtherStringMethods() {
    // * CompareTo - returns 0, -ve or +ve value based on ASCII values of the Strings by doing their difference
    // String s1 = "SACHIN";
    // String s2 = "SACHIN";
    // int result = s1.compareTo(s2);
    // System.out.println(result);

    // if (result == 0)
    //   System.out.println("Strings are Equal");
    // else 
    //   System.out.println("Strings are not Equal");

    // String s = "RajaRamMohanRoy";
    // String[] str = s.split("a");
    // for (String string : str) {
    //   System.out.print(string);
    // } // * RjRmMohnRoy
    // System.out.println();

    // String s = "Raja Ram Mohan Roy";
    // String[] str = s.split(" ");
    // for (String string : str) {
    //   System.out.print(string);
    // } // * RajaRamMohanRoy
    // System.out.println(str.length);   // * 4 - as Raja, Ram, Mohan, Roy -> Total 4 strings.

    String s = "   Raja Ram Mohan    Roy   ";
    System.out.println(s.trim());   // * "Raja Ram Mohan    Roy"
    System.out.println(s.strip());  // * "Raja Ram Mohan    Roy"
    System.out.println(s.stripLeading());   // * "Raja Ram Mohan    Roy"
    System.out.println(s.stripTrailing());  // * "   Raja Ram Mohan    Roy"
    
  }
};