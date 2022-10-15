package com.teamguppy.model;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Location {

  private static String name;

  public Location(String name) {
    this.name = name;
  }

  public static void setName(String name) {
    Location.name = name;
  }

  public static String getName() {
    return name;
  }





  public static Location findLocation(String location, String direction)
      throws IOException, ParseException, URISyntaxException {
//    System.out.println("Hit here" + location + direction);


    URL file = Location.class.getResource("/location.json");
    Path path = Paths.get(file.toURI());
    byte[] bytes = Files.readAllBytes(path);
    String fileContent = new String(bytes);
    System.out.println(location);

    if (file == null){
      System.out.println("no file found");
    }


    JSONParser parser = new JSONParser();
    Object obj = parser.parse(fileContent);

    JSONObject jsonObject = (JSONObject) obj;
    Location location2 = null;

    Map locationList = (Map) jsonObject.get(location);

    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      if (pair.getKey().equals(direction)) {
//        System.out.println(pair.getValue());
          String location1 = pair.getValue().toString();
          location2 = new Location(location1);
          break;
      }else{
        location2 = new Location(location);
      }
    }
    if (location2.toString().equals(location)){
      System.out.println("There is no room in " + direction);
    }
    return location2;
  }

  public static void roomDescription(String location) throws IOException, ParseException, URISyntaxException {

    URL file = Location.class.getResource("/location.json");
    Path path = Paths.get(file.toURI());
    byte[] bytes = Files.readAllBytes(path);
    String fileContent = new String(bytes);


    JSONParser parser = new JSONParser();
    Object obj = parser.parse(fileContent);

    JSONObject jsonObject = (JSONObject) obj;


    Map locationList = (Map) jsonObject.get(location);
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
  public static void itemsInRoom(String location) throws IOException, ParseException, URISyntaxException {

    URL file = Location.class.getResource("/location.json");
    Path path = Paths.get(file.toURI());
    byte[] bytes = Files.readAllBytes(path);
    String fileContent = new String(bytes);

    JSONParser parser = new JSONParser();
    Object obj = parser.parse(fileContent);

    JSONObject jsonObject = (JSONObject) obj;

    Map locationList = (Map) jsonObject.get(location);
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


  @Override
  public String toString() {
    return getName();
  }

//  public static void main(String[] args) throws IOException, ParseException, URISyntaxException {
//    roomDescription("Ocean Floor");
//  }

}











