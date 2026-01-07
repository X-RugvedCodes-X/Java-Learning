package com.rugved.oops;

public class WrapperClasses {
  public static void main(String[] args) {
    @SuppressWarnings("unused")
    int a = 10;

    // Integer i = new Integer(10); //* Deprecated
    // System.out.println("i: " + i);

    //* Primitive -> Object     = Boxing */
    //* Object    -> Primitive  = UnBoxing */

    Integer i = Integer.valueOf(10);
    System.out.println("i: " + i);

    //* Boxing */
    int n1 = 14;
    //* Auto Boxing */
    @SuppressWarnings("unused")
    Integer n2 = n1;

    //* UnBoxing */
    Integer n3 = Integer.valueOf(44);
    //* Auto UnBoxing */
    @SuppressWarnings("unused")
    int n4 = n3;
    //* Manual UnBoxing */
    @SuppressWarnings("unused")
    int n5 = n3.intValue();

  }
}