package com.rugved.weakhashmap;

import java.util.WeakHashMap;

public class Main {
  public static void main(String[] args) {
    System.out.println("hello, world !");
    // * As in previous section we studied about, Weak Reference, The Weak HashMap automatically Deletes the Weak References Stored in it, the weak keys in it will be removed automically when not in use
    WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
    // * Here the keys are string literals and we know that string literals are stored in SCP with strong reference
    // imageCache.put("img1", new Image("Image 1"));
    // imageCache.put("img2", new Image("Image 2"));

    // * Now As we Created Object on Heap our so key1 key2 point to heap and not towards SCP, stating weak Keys
    // String key1 = new String("img1");    // * Signifying that key1 and key2 have different address unlike when we do String s = "str" string literals
    // String key2 = new String("img2");
    // imageCache.put(key1, new Image("Image 1"));
    // imageCache.put(key2, new Image("Image 2"));

    // * Much better like our previous section's example
    imageCache.put(new String("img1"), new Image("Image 1"));
    imageCache.put(new String("img2"), new Image("Image 2"));
    System.out.println(imageCache);     // * {img1=Image: Image 1, img2=Image: Image 2}
    System.gc();
    try {
      Thread.sleep(2000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Cache after running (some entries may be cleared): " + imageCache);   // * {}


  }
};