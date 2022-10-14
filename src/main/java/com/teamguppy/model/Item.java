package com.teamguppy.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Item {

  private static String name;
  private static String description;

  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public static void setName(String name) {
    Item.name = name;
  }

  public static void setDescription(String description) {
    Item.description = description;
  }

  public static String getName() {
    return name;
  }

  public static String getDescription(String item) {
    return description;
  }


  public static void findDescription(String item) throws IOException, ParseException {

    JSONParser parser = new JSONParser();
    String file = "item.json";
    Object obj = parser.parse(new FileReader(file));
    JSONObject jsonObject = (JSONObject) obj;
    //make the input in lower case to find in from item.json.
    String parsingItem = item.toLowerCase();
    Map locationList = (Map) jsonObject.get(parsingItem);

    Iterator<Entry> itr1 = locationList.entrySet().iterator();
    while (itr1.hasNext()) {
      Entry pair = itr1.next();

      if (pair.getKey().equals("description")) {
        String description = pair.getValue().toString();
        System.out.println(description);
      }
    }
  }
}
