package com.teamguppy.model;


import java.util.HashSet;
import java.util.Set;


public class Inventory {

  private String item;
  private static Set<String> itemArray = new HashSet<>();
//  private static Set<String> itemArray = new HashSet<>(Arrays.asList("guppy")); // Was using to test with guppy in inventory

  public Inventory(String item) {
    this.item = item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public static void setItemArray(Set<String> itemArray) {
    Inventory.itemArray = itemArray;
  }

  public static Set<String> getItemArray() {
    return itemArray;
  }


  public static Set<String> addItemToInventory(String item) {
    if (item.equals("guppy")) {
      if (itemArray.contains("KEY")) {
        itemArray.add(item.toUpperCase());
        removeItemFromInventory("Key");
        displayItemsInInventory();
      } else {
        System.out.println("You can't get Guppy. You need Key to get Guppy.");
      }
    } else {
      itemArray.add(item.toUpperCase());
    }
    return itemArray;
  }

  public static void displayItemsInInventory() {
    System.out.println("Your inventory: " + itemArray);
  }

  public static Set<String> removeItemFromInventory(String item) {
    String usedItem = item.toUpperCase();
    if (itemArray.contains(usedItem)) {
      itemArray.remove(usedItem);
      System.out.println("Your have used " + item + " from your inventory");
      return itemArray;
    } else {
      System.out.println("You don't have " + item + " in your inventory.");
    }
    return itemArray;
  }
}

