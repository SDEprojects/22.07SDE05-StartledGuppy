package com.teamguppy.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;


public class Inventory {

  private static Set<String> theList;
  private Set<String> item;
  private static Set<String> itemArray = new HashSet<>();
//  private static Set<String> itemArray = new HashSet<>(Arrays.asList("guppy")); // Was using to test with guppy in inventory

  public Inventory(Set<String> inventory) {
    itemArray = findInventoryInJson();

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
        displayItemsInInventory(itemArray);

      } else {
        System.out.println("You can't get Guppy. You need Key to get Guppy.");
      }
    } else {
      itemArray.add(item.toUpperCase());
      ;
    }
    return itemArray;
  }

  public static void displayItemsInInventory(Set<String> array) {
    if (array != null) {
      System.out.println("Your inventory: " + array);
    }
    if (array == null) {
      System.out.println("You have nothing in your inventory");
    }
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

  public static void saveInventoryToJson(Set<String> itemArray) {

    File file = new File("testing.json");

    Gson gson = new Gson();

    if (file.exists()) {

      try (FileWriter writer = new FileWriter(file)) {
        gson.toJson(itemArray, writer);

      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Inventory saved!");
    } else {
      try {
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(itemArray, fileWriter);
        fileWriter.close();

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static Set<String> findInventoryInJson() {
    InputStream inputStream = null;
    Set<String> inventory = null;
    File file = new File("testing.json");
    if (file.exists()) {
      try {
        // create Gson instance
//        inputStream = new FileInputStream(file);
        FileReader fileReader = new FileReader(file);
        Type type = new TypeToken<Set<String>>() {
        }.getType();
        Gson gson = new Gson();

//
        theList = gson.fromJson(fileReader, type);
        fileReader.close();
//        System.out.println(theList);

      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } finally {
        if (inputStream != null) {
          try {
            inputStream.close();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
    else{
      theList = new HashSet<>();
    }
    return theList;
  }
    public static void main (String[]args){

//    addItemToInventory("Coral Reef");
//    addItemToInventory("testing");
//    System.out.println(itemArray + "check");
//    saveInventoryToJson(itemArray);
      findInventoryInJson();

//    displayItemsInInventory();
//    removeItemFromInventory("Key");
    }
  }


