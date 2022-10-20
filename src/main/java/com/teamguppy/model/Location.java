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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Location findLocation(String location, String direction)
      throws URISyntaxException, IOException, ParseException {

    String location1 = null;
    Location location2 = new Location(location);
    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      if (pair.getKey().equals(direction)) {
        location1 = pair.getValue().toString();
        location2 = new Location(location1);
        break;
      } else {
        location1 = null;
      }
    }

    if (location1.equals(location)) {
      System.out.println("\nThere is no room in " + direction);
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
  public static String itemsInRoom(String location)
      throws IOException, ParseException, URISyntaxException {

    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      String pairKey = pair.getKey().toString();
      String pairValue = pair.getValue().toString();
      if (pairKey.equals("item")) {
        System.out.println("This room has " + pairValue + " " + pairKey);
        return pairValue;
      }
    }
    return null;
  }

  public static void animalInRoom(String location)
      throws IOException, ParseException, URISyntaxException {

    Map locationList = jsonParsing(location);
    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      String pairKey = pair.getKey().toString();
      String pairValue = pair.getValue().toString();
      if (pairKey.equals("animal")) {
        System.out.println("This room has " + pairValue + " " + pairKey);
      }
    }

  }


//  public static void copyJson() throws FileNotFoundException {
//    JSONObject testing = new JSONObject();
//
//    // putting data to JSONObject
////    testing.put("item", item);
//    String file = "src/main/resources/data/testing.json";
////
//    testing.putAll(jsonParsing("Challenger Deep"));
//    PrintWriter pw = new PrintWriter(file);
//    pw.write(testing.toJSONString());
//    pw.flush();
//    pw.close();
//  }

  public static Map jsonParsing(String location){

    JSONParser parser = new JSONParser();
    String file = "data/location.json";
    Object obj = null;
    try {
      obj = parser.parse(new InputStreamReader(Location.class.getClassLoader().getResourceAsStream(file)));
    } catch (IOException e) {
      System.out.println(e);
    } catch (ParseException e) {
      System.out.println(e);
    }
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

  public static void main(String[] args) throws IOException, ParseException, URISyntaxException {
    itemsInRoom("Kelp Forest");
  }
}











