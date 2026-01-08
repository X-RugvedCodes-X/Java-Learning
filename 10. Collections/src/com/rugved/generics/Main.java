package com.rugved.generics;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, generics !");
    // * Normal Arrays in Java are fast but ArrayList is not that fast due to Object conversion and interchange
    // * Normal Arrays are type-safe, Raw ArrayList is not type-safe, We must use Generics for it
    ArrayList<String> arrayList = new ArrayList<String>();    // * In Type primitive types are not allowed - ArrayList<int> this is not allowed
    arrayList.add("Java");
    arrayList.add("SpringBoot");
    arrayList.add("Microservices");
    // arrayList.add(1);  // ! Error

    ArrayList<Employee> employees = new ArrayList<Employee>();
    employees.add(new Employee(1, "Rugved", "Mumbai"));
    employees.add(new Employee(2, "Hyder", "Bengaluru"));
    employees.add(new Employee(3, "Naveen", "Bengaluru"));
    employees.add(new Employee(4, "Bandya", "Kankavli"));
    // * This Also works
    // System.out.println(employees); 
    // * But this is Good Practice
    // for (Employee employee : employees) {
    //   System.out.println(employee);
    // }

    CustomClassForGenerics<Integer> customClassForGenerics = new CustomClassForGenerics<Integer>(40);

    // ! Compile Time Error, as String cannot resolved to Integer
    // CustomClassForGenerics<Integer> customClassForGenerics = new CustomClassForGenerics<Integer>("Java"); 
    customClassForGenerics.displayType();
    System.out.println(customClassForGenerics.getReference());    // * 40
    System.out.println("*".repeat(40));
    // & Before Overriding toString
    // System.out.println(customClassForGenerics);                   // * com.rugved.generics.CustomClassForGenerics@7e9e5f8a

    // ^ After Overriding toString
    System.out.println(customClassForGenerics);       // * Type Of Generic Is: java.lang.Integer, Value is: 40
  }
};