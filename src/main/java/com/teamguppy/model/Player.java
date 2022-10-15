package com.teamguppy.model;

public class Player {

  private final Inventory inventory;
  private final Location location;


  public Player(Inventory inventory, Location location) {
    this.inventory = inventory;
    this.location = location;
  }

  public Inventory getInventory(){
    return inventory;
  }

  public Location getLocation(){
    return location;
  }




}
