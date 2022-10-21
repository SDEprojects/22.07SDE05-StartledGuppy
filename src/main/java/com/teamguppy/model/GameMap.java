package com.teamguppy.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class GameMap {


  @SerializedName("locations")
  @Expose
  private List<Room> locations = null;

  public List<Room> getLocations() {
    return locations;
  }

  public void setLocation(List<Room> locations) {
    this.locations = locations;
  }

  public GameMap createMap() {
    Gson gson = new Gson();
    BufferedReader br = null;
    GameMap location = null;

    try {
      JsonReader reader = new JsonReader(
          new BufferedReader(new InputStreamReader(GameMap.class.getResourceAsStream("/data/location.json"))));

      location = gson.fromJson(reader, GameMap.class);

      if (location != null) {
        for (Room loc : location.getLocations()) {
        }
        System.out.println("game map created");
      }
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return location;
  }

  public Room findLocation(GameMap map, String location) {
    Room findingLoc = null;
    if (map != null) {
      for (Room loc : map.getLocations()) {
        if (loc.getName().equals(location)) {
          findingLoc = loc;
        }
      }
    }else if (map == null){
      System.out.println("no map found");
    }
    return findingLoc;
  }

  public GameMap removeItemFromRoom(GameMap map, String item){
    String checkingItem = item.toLowerCase();
    Room updatedRoom = null;
    if (map != null) {
      for (Room loc : map.getLocations()) {
        if (loc.getItem() != null && loc.getItem().equals(item)) {
          loc.deleteItem(item);
        }
      }
    }else if (map == null){
      System.out.println("no map found");
    }
    return map;
  }

  public GameMap removeAnimalFromRoom(GameMap map, String monster){
    String checkingMonster = monster.toLowerCase();
    Room updatedRoom = null;
    if (map != null) {
      for (Room loc : map.getLocations()) {
        if (loc.getAnimal()!=null && loc.getAnimal().equals(monster)) {
          loc.deleteAnimal(monster);
        }
      }
    }else if (map == null){
      System.out.println("no map found");
    }
    return map;
  }

  public static void main(String[] args) {
    GameMap location = new GameMap();
    location = location.createMap();
    List<Room> map = location.getLocations();
//    location.findLocation(location, "Ocean Floor");
    location.removeItemFromRoom(location, "Medicine" );

  }
}