package com.teamguppy.model;


import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Inventory {



  public Inventory() {this.item = item;}


  private String item;
  private static ArrayList<String> itemArray = new ArrayList<>();

  public Inventory(String item) {this.item = item;}


  public void setItem(String item) {
    this.item = item;
  }

  // We need to pass the item as an argument from the Game instead of call the itemsInRoom function in here.
  public static ArrayList<String> addItemToInventory(String location, String item) {
    String currentItemInRoom = item;
    itemArray.add(currentItemInRoom);
    displayItemsInInventory(itemArray);
    System.out.println(itemArray);
    return itemArray;
  }


  private static void displayItemsInInventory(ArrayList<String> itemArray) {
    System.out.println(itemArray);
  }
  static ArrayList<String> removeItemFromInventory(String item) {
    displayItemsInInventory(itemArray);
    if (itemArray.contains(item)){
     itemArray.remove(item);
     return itemArray;
    }
    return null;
  }


//  public static void saveItem(String item) throws FileNotFoundException{
//
//    JSONObject userInventory = new JSONObject();
//
//    // putting data to JSONObject
//    userInventory.put("item", item);
//
//    PrintWriter pw = new PrintWriter("inventory.json");
//    pw.write(userInventory.toJSONString());
//
////    pw.flush();
////    pw.close();
//
//  }

  public static void main(String[] args) throws FileNotFoundException {
//    saveItem("testing1");
  }
}

