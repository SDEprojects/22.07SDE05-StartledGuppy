package com.teamguppy.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    GameMap location;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/data/location.json"));
      location = gson.fromJson(br, GameMap.class);

      if (location != null) {
        for (Room loc : location.getLocations()) {
        }
        System.out.println("game map created");
      }

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
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
        if (loc.getItem()!=null && loc.getItem().equals(item)) {
          loc.deleteItem(item);
          System.out.println("check "+ loc.getItem() +" " + loc.getItem());

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