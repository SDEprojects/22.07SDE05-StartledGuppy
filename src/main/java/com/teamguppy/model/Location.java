package com.teamguppy.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Location {

  private static String location;

  public Location(String location) {
    this.location = location;
  }

//  public static String getCurrentLocation(Location location) throws IOException, ParseException {
//    JSONParser parser = new JSONParser();
//    String file = "location.json";
//    Object obj = parser.parse(new FileReader(file));
//
//    JSONObject jsonObject = (JSONObject) obj;
//
//    Map locationList = (Map) jsonObject.get(location);
//    ArrayList locationArray = null;

//    Iterator<Entry> itr1 = location.iterator();
//    while (itr1.hasNext()) {
//      Entry pair = itr1.next();
//      System.out.println(pair.getKey() + " : " + pair.getValue());
//      locationArray.add(pair);

//    String location = (String) location.get()

//    return location;
//  }



  public void setCurrentLocation(String location) throws IOException, ParseException {

//
    System.out.println("your current location is " + location);
  }



  @Override
  public String toString() {
    return location;
  }

  public void findLocation(String location) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    String file = "location.json";
    Object obj = parser.parse(new FileReader(file));

    JSONObject jsonObject = (JSONObject) obj;

    Map locationList = (Map) jsonObject.get(location);
    ArrayList locationArray = null;

    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();
      System.out.println(pair.getKey() + " : " + pair.getValue());
      locationArray.add(pair);
    }


  }





//  public static void main(String[] args) throws IOException, ParseException {
//    Location location = new Location();
//    location.findLocation("Ocean Floor");
//
//  }
}


    // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
    // Iterators differ from enumerations in two ways:
    // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
    // 2. Method names have been improved.
//    Iterator<JSONObject> iterator = companyList.iterator();
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }




