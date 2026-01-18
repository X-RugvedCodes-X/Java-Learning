package com.rugved.weakhashmap;

public class Image {

  String image;
  public Image() {}
  public Image(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "Image: " + this.image;
  }
}