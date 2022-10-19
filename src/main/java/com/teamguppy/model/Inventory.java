package com.teamguppy.model;

import static com.teamguppy.model.Location.itemsInRoom;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.util.ArrayList;


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


  public static Set<String> addItemToInventory(String location)
      throws IOException, ParseException, URISyntaxException {
    String currentItemInRoom = itemsInRoom(location);
    itemArray.add(currentItemInRoom);
    displayItemsInInventory();
    return itemArray;
  }
  public static void displayItemsInInventory() {
    System.out.println(itemArray);
  }

  public static Set<String> removeItemFromInventory(String item) {
      if (itemArray.contains(item)) {
        itemArray.remove(item);
        System.out.println("Your have used " + item + " from your inventory");
        System.out.println(itemArray);
        return itemArray;
      }else {
        System.out.println("You don't have " + item + " in your inventory.");
      }
    System.out.println(itemArray);
    return itemArray;
  }

//    System.out.println(itemArray);
//    displayItemsInInventory(itemArray);
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

  public static void main(String[] args) throws IOException, ParseException, URISyntaxException {
    addItemToInventory("Coral Reef");
//    displayItemsInInventory();
    removeItemFromInventory("Key");
  }
}

