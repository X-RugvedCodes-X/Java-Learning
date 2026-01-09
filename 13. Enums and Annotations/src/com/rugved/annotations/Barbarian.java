package com.rugved.annotations;

@COC_Troop(type = "Ground", damage = 200)
public class Barbarian {
  private int hitpoints;

  @COC_Troop    // * No Error Here, As we had specified in the list that ElementType.CONSTRUTOR
  public Barbarian() {
    super();
  }

  // @COC_Troop    // * If we use it here then it gives error
  public int getHitpoints() {
    return hitpoints;
  }

  public void setHitpoints(int hitpoints) {
    this.hitpoints = hitpoints;
  }
};