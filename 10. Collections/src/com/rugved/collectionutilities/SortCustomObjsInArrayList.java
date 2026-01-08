package com.rugved.collectionutilities;

import java.util.Comparator;

public class SortCustomObjsInArrayList implements Comparator<Cricketer> {
  // * Comparator Method
  @Override
  public int compare(Cricketer c1, Cricketer c2) {
    if (c1.average > c2.average) {
      return 1;
    } else {
      return -1;
    }
  }
};