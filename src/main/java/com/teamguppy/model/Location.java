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


  private String location;

  public Location() throws IOException, ParseException {

  }

  public Location(String location) throws IOException, ParseException {
    this.location = location;
  }

  public void json(String location) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    String file = "location.json";
    Object obj = parser.parse(new FileReader(file));
    // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.


    JSONObject jsonObject = (JSONObject) obj;
    // A JSON array. JSONObject supports java.util.List interface.
    Map locationList = (Map) jsonObject.get(location);

    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Map.Entry pair = itr1.next();
      System.out.println(pair.getKey() + " : " + pair.getValue());
    }
    System.out.println(locationList);

  }





  public static void main(String[] args) throws IOException, ParseException {
    Location location = new Location();
    location.json("Ocean Floor");

  }
}


    // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
    // Iterators differ from enumerations in two ways:
    // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
    // 2. Method names have been improved.
//    Iterator<JSONObject> iterator = companyList.iterator();
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }




