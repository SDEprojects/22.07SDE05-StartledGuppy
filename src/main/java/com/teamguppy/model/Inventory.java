package com.teamguppy.model;

import static com.teamguppy.model.Location.itemsInRoom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;


public class Inventory {

  private String item;
  private static ArrayList<String> itemArray = new ArrayList<>();

  public Inventory(String item) {this.item = item;}

  public void setItem(String item) {
    this.item = item;
  }

  public static ArrayList<String> addItemToInventory(String location)
      throws IOException, ParseException, URISyntaxException {
    String currentItemInRoom = itemsInRoom(location);
    itemArray.add(currentItemInRoom);
    displayItemsInInventory(itemArray);
//    System.out.println(itemArray);
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

