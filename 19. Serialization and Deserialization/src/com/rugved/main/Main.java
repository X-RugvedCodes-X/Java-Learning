package com.rugved.main;

import java.io.IOException;

public class Main {

  // * Serialization -> is the process of converting the state of Object into a Byte Stream
  // * De-Serialization -> Reversal of Serialization
  public static void main(String[] args) {
    try {
      Serialization.serialize();
      Deserialization.deserialize();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
};