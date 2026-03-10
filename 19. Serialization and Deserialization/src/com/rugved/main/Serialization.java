package com.rugved.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
  public static void serialize() throws IOException {
    Student student = new Student("Rugved", "abcd@gmail.com", 21, "Mumbai");

    FileOutputStream fileOutputStream = new FileOutputStream("Object.txt", true);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

    // * Serialization
    objectOutputStream.writeObject(student);

    // * Closing Files
    fileOutputStream.close();
    objectOutputStream.close();

    System.out.println("Object state is Transfering File Object.txt");
  }
}
