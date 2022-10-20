package com.teamguppy.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Item {

  private String name;



  public Item(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public String getName() {
    return name;
  }


  public static void findDescription(String item) throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    String file = "data/item.json";
    Object obj = parser.parse(new InputStreamReader(Item.class.getClassLoader().getResourceAsStream(file)));
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


