package com.teamguppy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Room {

  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("south")
  @Expose
  private String south;
  @SerializedName("east")
  @Expose
  private String east;
  @SerializedName("west")
  @Expose
  private String west;
  @SerializedName("north")
  @Expose
  private String north;
  @SerializedName("animal")
  @Expose
  private String animal;
  @SerializedName("item")
  @Expose
  private String item;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSouth() {
    return south;
  }

  public void setSouth(String south) {
    this.south = south;
  }

  public String getEast() {
    return east;
  }

  public void setEast(String east) {
    this.east = east;
  }

  public String getWest() {
    return west;
  }

  public void setWest(String west) {
    this.west = west;
  }

  public String getNorth() {
    return north;
  }

  public void setNorth(String north) {
    this.north = north;
  }

  public String getAnimal() {
    return animal;
  }

  public void setAnimal(String animal) {
    this.animal = animal;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public void deleteItem(String item) {
    this.item = null;
  }

  public void deleteAnimal(String animal) {
    this.animal = null;
  }

  public static void roomDescription(Room location) {
    String south = location.getSouth();
    String north = location.getNorth();
    String west = location.getWest();
    String east = location.getEast();
    String direction = null;

    if (south !=null) {
      System.out.println("[This room has " + south + " on South.]");
    }
    if (north != null) {
      System.out.println("[This room has " + north + " on North.]");
    }
    if (east != null) {
      System.out.println("[This room has " + east + " on East.]");
    }
    if (west != null) {
      System.out.println("[This room has " + west + " on West.]");
    }
  }


  public static void displayItems(Room location) {
    if (location.getItem() !=null ){
      System.out.println("This room has " + location.getItem());
    }else{
      System.out.println("This room doesn't have any items");
    }
  }




}





