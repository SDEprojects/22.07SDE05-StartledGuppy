package com.teamguppy.view;

import java.util.HashMap;

public class Learn {

  public static HashMap<String, String> learnAboutOcean = new HashMap<>() {{
    put("Ocean Floor",
        "1. The ocean floor is the bottom of the ocean.\n"
            + "2. The ocean floor covers more than 70 percent of the planet’s surface.It has many levels.");
    put("Mariana Trench",
        "1. The Mariana Trench is the deepest oceanic trench on Earth.\n"
            + "2. It is located in the western Pacific Ocean about 200 kilometres (124 mi) east of the Mariana Islands");
    put("Challenger Deep",
        "1. The Challenger Deep is the deepest-known point of the seabed of Earth.\n"
            + "2. Microorganisms, shrimp, marine worms, and sea cucumbers live at the bottom of the Challenger Deep.");
    put("Ocean Plant Forest",
        "1. Ocean Plant forests are formed by seaweeds, which are types of algae.\n"
            + "2. Just like trees on land, these seaweeds offer habitat, food and shelter to a wide variety of marine organisms.");
    put("Kelp Forest",
        "1. Kelp are large brown algae that live in cool, relatively shallow waters close to the shore.\n"
            + "2. A kelp forest has a greater variety and higher density of plants and animals than almost any other ocean community.");
    put("Coral Reef",
        "1. A coral reef is an underwater ecosystem characterized by reef-building corals.\n"
            + "2. Reefs are formed of colonies of coral polyps held together by calcium carbonate.");
    put("Seaweed Forest",
        "1. Seaweeds have what are called holdfasts instead of roots.\n"
        + "2. These holdfasts merely hold the plant in place rather than absorbing any nutrients like roots.");
  }};

  public static HashMap<String, String> learnAboutOceanAnimal = new HashMap<>() {{
    put("Turtle",
        "1. There are seven species of sea turtles: flatback, green, hawksbill, leatherback, loggerhead, Kemp's ridley, and olive ridley sea turtles.\n"
            + "2. Sea turtles may be carnivorous (meat eating), herbivorous (plant eating), or omnivorous (eating both meat and plants).\n"
            + "3. Adult sea turtles have a few predators, mostly large sharks such as Tiger sharks.");
    put("Jellyfish",
        "1. Jellyfish have a bell-shaped body and long tentacles that can sting to catch their prey.\n"
            + "2. They have no brain and are 98% water.\n"
            + "3. Larger jellyfish prey on food sources such as fish, shrimp, and crab.\n"
            + "4. The whale shark, turtles etc are the predators of the jellyfish.");
    put("Goblin Shark",
        "1. Goblin Sharks Are Deep Sea Creatures.\n"
            + "2. Goblin Shark is also known as the 'The Living Fossil'.\n"
            + "3. Goblin Sharks Are Old As Dinosaurs.\n"
            + "4. The Goblin Shark Shrinks When It Gets Older.\n"
            + "5. Goblin Sharks Will Eat Just About Anything.");
  }};
  private static final String ENCOUNTER_GOBLIN_SHARK = "There’s a big scary Goblin Shark monster in here!\n"
      + "Goblin Shark: I'm a crazy goblin shark, rawr!"
      + "Goblin Shark: I'm going to eat you, rawr, rawr!\n"
      + "You have encountered a giant Goblin Shark monster in here!"
      + "You’ve taken some damage from the Goblin Shark.";

  private static final String ENCOUNTER_JELLYFISH = "There’s a jiggly Jellyfish monster in this room!! Oh, what ever should I do?!\n"
      + "Jiggly Jellyfish: I'm the Jiggly Jellyfish monster!"
      + "Jiggly Jellyfish: Going to give you a Jiggly Jellyfish sting!"
      + "Jiggly Jellyfish: You'll never stop me!\n"
      + "You have encountered a giant Goblin Shark monster in here!"
      + "The Jellyfish stung you and you took some damage.";

  public static void learnAboutOceanForest(String noun) {
    if (learnAboutOcean.containsKey(noun)) {
      System.out.println("There is something interesting to learn about " + noun + ".");
      System.out.println(learnAboutOcean.get(noun));
    } else {
      System.out.println("There is nothing interesting to learn.");
    }
  }
  public static void learnAboutOceanAnimal(String noun) {
    if (learnAboutOceanAnimal.containsKey(noun)) {
      System.out.println("There is something interesting to learn.");
      System.out.println(learnAboutOceanAnimal.get(noun));
    } else {
      System.out.println("There is nothing interesting to learn.");
    }
  }

  public static void encounterGoblinSharkPrint(){
    System.out.println(ENCOUNTER_GOBLIN_SHARK);
  }
  public static void encounterJellyfishPrint(){
    System.out.println(ENCOUNTER_JELLYFISH);
  }

  public static void main(String[] args) {
    learnAboutOceanForest("Mariana Trench");
    learnAboutOceanAnimal("Jellyfish");
  }

}

