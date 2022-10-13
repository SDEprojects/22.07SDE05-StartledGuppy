package com.teamguppy.model;

import java.io.FileReader;
import java.io.IOException;
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
      throws IOException, ParseException {
    System.out.println("Hit here" + location + direction);
    JSONParser parser = new JSONParser();
    String file = "location.json";
    Object obj = parser.parse(new FileReader(file));

    JSONObject jsonObject = (JSONObject) obj;
    Location location2 = null;

    Map locationList = (Map) jsonObject.get(location);


    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      if (pair.getKey().equals(direction)) {
        System.out.println(pair.getValue());
        String location1 = pair.getValue().toString();
        location2 = new Location(location1);

      }
    }
    System.out.println("location2 is " + location2);
    return location2;
  }


  @Override
  public String toString() {
    return getName();
  }


  public static void main(String[] args) throws IOException, ParseException {

  }
}











