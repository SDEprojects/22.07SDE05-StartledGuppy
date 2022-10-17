package com.teamguppy.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;


public class Inventory {

  private static String item;
  public Inventory(String item) {this.item = item;}

  public static void setItem(String item) {
    Inventory.item = item;
  }

  public static void saveItem(String item) throws FileNotFoundException{

    JSONObject userInventory = new JSONObject();

    // putting data to JSONObject
    userInventory.put("item", item);

    PrintWriter pw = new PrintWriter("inventory.json");
    pw.write(userInventory.toJSONString());

    pw.flush();
    pw.close();

  }

  public static void main(String[] args) throws FileNotFoundException {
    saveItem("testing2");
  }
}
