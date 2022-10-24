package com.teamguppy.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
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
    }if("guppy".equals(location.getItem())){
      System.out.println("Guppy is in locked door. Please, use your key to open the door and save Guppy!");
    }
  }

  public void saveCurrentLocationToJson(String location) {
    File file = new File("savedCurrentLocation.json");

    Gson gson = new Gson();

    if (file.exists()) {

      try (FileWriter writer = new FileWriter(file)) {
        gson.toJson(location, writer);

      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println("Saving your game...");
    } else {
      try {
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(location, fileWriter);
        fileWriter.close();
        System.out.println("Saving your game... ");

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }


  public static String openSavedCurrentLocation() {
    InputStream inputStream = null;
    String location = null;
    File file = new File("savedCurrentLocation.json");

    if (file.exists()) {
      try {
        FileReader fileReader = new FileReader(file);
        Gson gson = new Gson();
        Type type = new TypeToken<String>() {
        }.getType();
        location = gson.fromJson(fileReader, type);
        fileReader.close();

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
    System.out.println(location);
    return location;
  }
}





