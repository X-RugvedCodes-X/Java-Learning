package com.rugved.annotations01;

@COCTroop
public class Barbarian {
  @ImportantField
  String name;
  int damage;
  public Barbarian(String name, int damage) {
    this.name = name;
    this.damage = damage;
  }

  @AttackImmediately(times = 5)
  public void attack() {
    System.out.println("Attack !");
  }

  public void sleep() {
    System.out.println("Sleep !");
  }
}
