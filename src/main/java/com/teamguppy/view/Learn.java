package com.teamguppy.view;

import java.util.HashMap;

public class Learn {

  public static HashMap<String, String> learnAboutOcean = new HashMap<>() {{
    put("Ocean Floor",
        "The ocean floor is the bottom of the ocean.\n"
            + "The ocean floor covers more than 70 percent of the planet’s surface.It has many levels.");
    put("Mariana Trench",
        "The Mariana Trench is the deepest oceanic trench on Earth.\n"
            + "It is located in the western Pacific Ocean about 200 kilometres (124 mi) east of the Mariana Islands");
    put("Challenger Deep",
        "The Challenger Deep is the deepest-known point of the seabed of Earth.\n"
            + "Microorganisms, shrimp, marine worms, and sea cucumbers live at the bottom of the Challenger Deep.");
    put("Ocean Plant Forest",
        "Ocean Plant forests are formed by seaweeds, which are types of algae.\n"
            + "Just like trees on land, these seaweeds offer habitat, food and shelter to a wide variety of marine organisms.");
    put("Kelp Forest",
        "Kelp are large brown algae that live in cool, relatively shallow waters close to the shore.\n"
            + "A kelp forest has a greater variety and higher density of plants and animals than almost any other ocean community.");
    put("Coral Reef",
        "A coral reef is an underwater ecosystem characterized by reef-building corals.\n"
            + "Reefs are formed of colonies of coral polyps held together by calcium carbonate.");
    put("Seaweed Forest", "Seaweeds have what are called holdfasts instead of roots.\n"
        + "These holdfasts merely hold the plant in place rather than absorbing any nutrients like roots.");
  }};

  public static HashMap<String, String> learnAboutOceanAnimal = new HashMap<>() {{
    put("Turtle",
        "The seven species of sea turtles are flatback, green, hawksbill, leatherback, loggerhead, Kemp's ridley, and olive ridley sea turtles.\n"
            + "Sea turtles may be carnivorous (meat eating), herbivorous (plant eating), or omnivorous (eating both meat and plants).\n"
            + "Adult sea turtles have a few predators, mostly large sharks such as Tiger sharks.");
    put("Jellyfish",
        "Jellyfish have a bell-shaped body and long tentacles that can sting to catch their prey.\n"
            + "They have no brain and are 98% water.\n"
            + "Larger jellyfish prey on food sources such as fish, shrimp, and crab."
            + "The whale shark, turtles etc are the predators of the jellyfish.");
    put("Goblin Shark",
        "Goblin sharks are a species of fish that usually live at the bottom of the ocean along continental shelves .\n"
            + "Goblin Shark is also known as the Living Fossil.");
  }};

  public static void learnAboutOceanForest(String noun) {
    if (learnAboutOcean.containsKey(noun)) {
      System.out.println(learnAboutOcean.get(noun));
    }
  }
  public static void learnAboutOceanAnimal(String noun) {
    if (learnAboutOceanAnimal.containsKey(noun)) {
      System.out.println(learnAboutOceanAnimal.get(noun));
    }
  }

  public static void main(String[] args) {
    learnAboutOceanForest("Mariana Trench");
    learnAboutOceanAnimal("Jellyfish");
  }

}

