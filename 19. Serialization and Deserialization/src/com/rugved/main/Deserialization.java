package com.rugved.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
  public static void deserialize() {
    try {
      FileInputStream fileInputStream = new FileInputStream("Object.txt");
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 

      Student student = (Student) objectInputStream.readObject();
      
      student.displayName();
      System.out.println(student);
      objectInputStream.close();
      fileInputStream.close();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
