package com.rugved.trywithresources;

public class Barbarian implements AutoCloseable {
  @Override
  public void close() throws Exception {
    System.out.println("Close Method From Barbarian");
  }
};