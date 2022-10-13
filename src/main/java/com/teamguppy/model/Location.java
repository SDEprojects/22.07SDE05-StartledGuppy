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

  @Override
  public String toString() {
    return location;
  }

}











