package com.teamguppy.model;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Location {
  private static String name;
  private String item;
  private String animal;


  public Location(String name) {
    this.name = name;
  }
  public Location(String name, String item, String animal) {
    this.name = name;
    this.item = item;
    this.animal = animal;
  }

  public static String getName() {
    return name;
  }

  public static void setName(String name) {
    Location.name = name;
  }

  public static Location findLocation(String location, String direction)
      throws URISyntaxException, IOException, ParseException {

    Location location2 = null;
    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      if (pair.getKey().equals(direction)) {
        String location1 = pair.getValue().toString();
        location2 = new Location(location1);
        break;
      } else {
        location2 = new Location(location);
      }
    }
    if (location2.toString().equals(location)) {
      System.out.println("There is no room in " + direction);
    }
    return location2;
  }

  public static void roomDescription(String location)
      throws IOException, ParseException, URISyntaxException {

    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      String pairKey = pair.getKey().toString();
      String pairValue = pair.getValue().toString();
      if (pairKey.equals("east") || pairKey.equals("west") || pairKey.equals("south")
          || pairKey.equals("north")) {
        System.out.println("[This room has " + pairValue + " on " + pairKey + ".]");
      }
    }
  }

  public static void itemsInRoom(String location)
      throws IOException, ParseException, URISyntaxException {

    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    Entry pair = itr1.next();
    String pairKey = pair.getKey().toString();
    String pairValue = pair.getValue().toString();
    if (pairKey.equals("item") || pairKey.equals("animal")) {
      System.out.println("This room has " + pairValue + " " + pairKey);
    } else {
      System.out.println("[There is no item or animal in the room.]");
    }
  }

  public static Map jsonParsing(String location)
      throws URISyntaxException, IOException, ParseException {

    JSONParser parser = new JSONParser();
    String file = "data/location.json";
    Object obj = parser.parse(new InputStreamReader(Location.class.getClassLoader().getResourceAsStream(file)));
    JSONObject jsonObject = (JSONObject)obj;

    if (file == null) {
      System.out.println("no file found");
    }

    return (Map) jsonObject.get(location);
  }

  @Override
  public String toString() {
    return getName();
  }

}











