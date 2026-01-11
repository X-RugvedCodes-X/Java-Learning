package com.rugved.trywithresources;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    System.out.println("hello, try with resources");

    // * Using this Try with Resources Syntax we need not to use finally and close the resource as from Java 8 the Exception implements AutoCloseable Interface
    // try(BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))) {

    // } catch(Exception e) {
    //   e.printStackTrace();
    // }

    // * We can even create our own catch message with this try with resources
    try (Barbarian barbarian = new Barbarian()) {
      
    }
  }
}