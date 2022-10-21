package com.teamguppy.model;

import com.teamguppy.controller.Controller;
import com.teamguppy.view.Learn;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.parser.ParseException;

public class Game {

  private static Room currentLocation;
  private Controller con = new Controller();
  //  private ArrayList<String> currentInventory1 = new ArrayList<>();
  private Boolean wounded = false;
  //  private static final String startingLocation = "Ocean Floor";
  private static final String startingLocation = "Ocean Floor";
  private Set<String> currentInventory = new HashSet<>();

  private GameMap gameMap = new GameMap();

  private String currentItem;


  public Game() {
    setGameMap(gameMap);
    setCurrentLocation(startingLocation);
    this.currentInventory = new HashSet<>();
  }

  public void setGameMap(GameMap gameMap) {
    this.gameMap = gameMap.createMap();
  }

  private void setCurrentLocation(String location) {
    this.currentLocation = gameMap.findLocation(gameMap, location);
  }

  public void setCurrentInventory(Set<String> currentInventory) {
    this.currentInventory = currentInventory;

  }

  public void setCurrentItem(String item) {
    this.currentItem = item;
  }

  public static Room getCurrentLocation() {
    return currentLocation;
  }

  public Set<String> getCurrentInventory() {
    return currentInventory;
  }

  public void landingRoom() throws IOException, ParseException, URISyntaxException {
    String command = null;
    try (Scanner sc = new Scanner(System.in)) {
      label:
      do {
        if (currentLocation.getName().equals("Ocean Floor")) {
          System.out.println("\nEnter 'yes' to continue and 'quit' to end the game.");
          command = sc.nextLine();
          switch (command) {
            case "yes":
              startGame();
              break label;
            case "quit":
              endGame();
              break label;
          }
        }
      } while (validStartInput(command));
    }
  }


  private static Boolean validStartInput(String input) {
    if (!input.equals("yes") || !input.equals("quit")) {
      System.out.println("Sorry, I don't understand");
    }
    return (true);
  }

  private void startGame() throws IOException, ParseException, URISyntaxException {
    do {
      System.out.println("\n[Your current location is " + currentLocation.getName() + ".]");
      userMove();
    } while (true);
  }

  private void endGame() throws IOException, ParseException, URISyntaxException {

    System.out.println(
        "Are you sure you wish to exit the game?\nEnter 'yes' to exit and 'no' to return.");
    String input = userInput();
    if (input.equals("yes")) {
      System.out.println("Bye! See you later.");
    } else if (input.equals("no")) {
      landingRoom();
    }
  }

  // parsing user input for the verb + noun
  // we can make function for each verb, and call the function in here


  private void userMove() throws IOException, ParseException, URISyntaxException {
    boolean validMove;
    String verb;
    String noun;

    do {
      noun = "";
      roomDescription(currentLocation);
//      currentInventory = Inventory.findInventoryInJson();
      Inventory.displayItemsInInventory(currentInventory);
      System.out.println("\nWhat would you like to do next? ");
      String input = userInput();
      String[] arr = input.toLowerCase().split(" ");
      verb = arr[0];
      validMove = validMove(verb);
      if (arr.length == 2) {
        noun = arr[1];
      }
    } while (!(validMove && validItem(noun)));
//      if (currentLocation.toString().equals("Ocean Floor")) {
//        System.out.println("TEST WIN!");
//      }
    if (verb.equals("help")) {
      userHelp();
    } else if(verb.equals("save")) {
      Inventory.saveInventoryToJson(currentInventory);
    } else if (verb.equals("go") || verb.equals("swim") || verb.equals("move")) {
      findLocationByDirection(noun.toLowerCase());
      itemsInRoom(currentLocation);
      checkMonster(currentLocation);

      if (playerWins()) {
        con.displayPlayerWins();
//          System.exit(0);
      }
    } else if (verb.equals("get") && currentItem != null && noun.toLowerCase()
        .equals(currentItem.toLowerCase())) {
      currentInventory = Inventory.addItemToInventory(currentItem);
//      getItemCondition(currentItem);
      gameMap.removeItemFromRoom(gameMap, currentItem);
    } else if (verb.equals("use")) {
      checkIfUserUsesCorrectItem(currentLocation, noun.toLowerCase());
//      Inventory.displayItemsInInventory();
    } else if (verb.equals("look") || verb.equals("examine")) {
      displayItemDescription(noun);
    } else if (verb.equals("learn")) {
      learnAboutRoom(currentLocation);
    } else if (verb.equals("talk") && noun.equals("turtle")) {
      turtleTalk();
    } else {
//      System.out.println(
//          "You try to talk to the " + noun + ", but the " + noun + " doesn't talk back...");
      System.out.println("There's nothing you can do with " + noun + " here. ");
    }
  }

  private void checkIfUserUsesCorrectItem(Room location, String noun) {
    if (noun.equals("squid") || noun.equals("medicine") || noun.equals("cloak")) {
      removeMonster(location, noun.toUpperCase());
      currentInventory = Inventory.removeItemFromInventory(noun.toUpperCase());
    } else if (noun.equals("key")) {
      if (location.getName().equals("Engine Room")) {
        System.out.println("You found Guppy. Key can be used to get Guppy.");
      } else {
        System.out.println("You can't use key here. You can use key to get Guppy.");
      }
    }
  }


  public void findLocationByDirection(String direction) {
    String room = null;
    switch (direction) {
      case "south":
        room = currentLocation.getSouth();
        break;
      case "north":
        room = currentLocation.getNorth();
        break;
      case "east":
        room = currentLocation.getEast();
        break;
      case "west":
        room = currentLocation.getWest();
    }if(room != null){
      setCurrentLocation(room);
    }else{
      System.out.println("Oops, there's nothing there");
    }
  }

  public void checkMonster(Room currentLocation) {
    String goblinShark = "Goblin Shark";
    String jellyFish = "Jellyfish";
    String monster = currentLocation.getAnimal();
    if (monster != null) {
      if (monster.equals(goblinShark)) {
        encounterMonster(goblinShark);
      } else if (monster.equals(jellyFish)) {
        encounterMonster(jellyFish);
      }
    }
  }

  private void removeMonster(Room location, String item) {
    String monster = location.getAnimal();
//    if (monster != null) {
    if (monster.equals("Goblin Shark")) {
      if ((item.equals("MEDICINE") && currentInventory.contains("MEDICINE")) || ((
          item.equals("SQUID") && currentInventory.contains("SQUID")))) {
        gameMap.removeAnimalFromRoom(gameMap, monster);
        System.out.println(monster + " is out of the way.");
      }
    }
    if (monster.equals("Jellyfish")) {
      if ((item.equals("MEDICINE") && currentInventory.contains("MEDICINE")) || ((
          item.equals("CLOAK") && currentInventory.contains("CLOAK")))) {
        gameMap.removeAnimalFromRoom(gameMap, monster);
        System.out.println(monster + " is out of the way.");
      }
    }
  }


  // when the players go to the monster room, this function will be called.
  // This will check the user's inventory and if there's no item that can be used against moster,
  // the player will be sent back to the starting place.
  public void encounterMonster(String monster) {
    if (monster.equals("Goblin Shark")) {
      System.out.println("You have encountered a giant Goblin Shark monster in here!"
          + "You’ve taken some damage from the Goblin Shark.");
      if (currentInventory.contains("MEDICINE")) {
        System.out.println("You can use your medicine to heal yourself.");
        wounded = true;
        // need use item function here
      } else if (currentInventory.contains("SQUID")) {
        System.out.println(
            "You can use squid from your inventory to blind the Goblin Shark with squid ink!");
        wounded = true;
        // need use item function here
      } else {
        System.out.println(
            "You are sent back to Ocean Floor.\n"
                + "You need to get medicine to heal yourself when encounter Goblin Shark, or a squid to sneak past the Goblin shark monster!\n");
//        System.out.println("Your are now in " + currentLocation.getName());
        setCurrentLocation(startingLocation);
      }
    }
    if (monster.equals("Jellyfish")) {
      System.out.println(
          "You have encountered a giant Goblin Shark monster in here!"
              + "The Jellyfish stung you and you took some damage");
      if (currentInventory.contains("MEDICINE")) {
        System.out.println(
            "You can use your medicine to heal yourself.");
        wounded = true;
        // need use item function here
      } else if (currentInventory.contains("CLOAK")) {
        System.out.println(
            "You can use cloak to sneak past the Jellyfish monster!");
        wounded = true;
      } else {
        System.out.println(
            "You are sent back to Ocean Floor.\n"
                + "You need to get medicine to heal yourself when encounter Jellyfish, or a cloak to sneak past the Jellyfish monster!\n");
        setCurrentLocation(startingLocation);
        System.out.println("Your are now in " + currentLocation);
      }
    }
//    gameMap.removeAnimalFromRoom(gameMap, monster);
  }

  public static void roomDescription(Room location)
      throws IOException, ParseException, URISyntaxException {
    Room.roomDescription(location);
  }

  public void itemsInRoom(Room location) {
    location.displayItems(location);
    setCurrentItem(location.getItem());
  }


  public static void learnAboutRoom(Room location) {
    Learn.learnAboutOceanForest(location.getName());
    String animal = location.getAnimal();
    if (animal != null) {
      Learn.learnAboutOceanAnimal(animal);
    }
  }

  public void addItemToInventory(String location, String noun)
      throws IOException, ParseException, URISyntaxException {
    String item = Location.itemsInRoom(location);
    if (item != null && item.equals(noun)) {
      currentInventory = Inventory.addItemToInventory(item);
    } else {
      System.out.println("There is no " + noun + " in this room.");
    }
  }

  public static void displayItemDescription(String item) throws IOException, ParseException {
    Item.findDescription(item);
  }

  public boolean playerWins() {
    boolean playerWon = false;
    if (currentLocation.getName().equals(startingLocation) && Inventory.getItemArray()
        .contains("guppy")) {
      playerWon = true;
    }
    return playerWon;
  }

  public void userHelp() {
    con.displayCommands();
  }

  public void turtleTalk() {
    con.displayTurtleTalk();
  }

  // validate user's move input
  private static Boolean validMove(String move) {
    Set<String> moves = new HashSet<>(
        Arrays.asList("go", "swim", "move", "get", "grab", "look", "examine", "help", "talk", "use",
            "learn", "save"));
    if (moves.contains(move)) {
      return true;
    } else {
      System.out.println(
          "Sorry, I don't understand. Please check the Game Commands for valid move.");
      return false;
    }
  }

  private static Boolean validItem(String item) {
    Set<String> items = new HashSet<>(
        Arrays.asList("north", "south", "east", "west", "key", "medicine", "squid", "cloak",
            "turtle", "guppy", ""));
    if (items.contains(item)) {
      return true;
    } else {
      System.out.println(
          "Sorry, I don't understand. Please check the Game Commands for valid item.");
      return false;
    }
  }

  private static String userInput() {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    return input;
  }

}

