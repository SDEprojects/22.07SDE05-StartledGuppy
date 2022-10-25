package com.teamguppy.model;

import com.teamguppy.controller.Controller;
import com.teamguppy.view.Learn;
import com.teamguppy.view.Sound;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {

  private static Room currentLocation;
  private Sound sound = new Sound();

  //  private ArrayList<String> currentInventory1 = new ArrayList<>();
  private Boolean wounded = false;
  //  private static final String startingLocation = "Ocean Floor";
  private static final String startingLocation = "Ocean Floor";
  private Set<String> currentInventory = new HashSet<>();

  private GameMap gameMap = new GameMap();

  private String currentItem;

  private Controller controller = new Controller();


  public Game() {
    setGameMap(gameMap);
    setCurrentLocation(startingLocation);
    currentInventory = new HashSet<>();
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

  public void checkSavedGame() {
    Boolean savedGame = gameMap.checkSavedGame();
    Boolean validInput = true;
    do {
      if (savedGame) {
        System.out.println("You have saved game. Do you want to continue your previous game?");
        String input = userInput();
        if (input.toLowerCase().equals("yes")) {
          gameMap = gameMap.openSavedMap();
          currentInventory = Inventory.findInventoryInJson();
          String savedLocation = Room.openSavedCurrentLocation();
          setCurrentLocation(savedLocation);
          setCurrentItem(currentLocation.getItem());
          validInput = true;
        } else if (input.toLowerCase().equals("no")) {
          System.out.println("Creating new game...");
          validInput = true;
        } else if (input.toLowerCase().equals("quit")) {
          endGame();
          validInput = true;
        } else {
          System.out.println("Please, type 'yes' or 'no'.");
          validInput = false;
        }
      }
    } while (!validInput);
  }

  public void landingRoom() {
    String command = null;

    try (Scanner sc = new Scanner(System.in)) {
      label:
      do {
        if (currentLocation.getName().equals("Ocean Floor")) {
          System.out.println("\nEnter 'yes' to continue and 'quit' to end the game.");
          command = sc.nextLine().toLowerCase().trim();
          ;
          switch (command) {
            case "yes":
              startGame();
              break label;
            case "quit":
            case "no":
              endGame();
              break label;
          }
        } else {
          startGame();
        }
//      } while (!validStartInput(command));
      } while (true);
    }
  }

//  private static Boolean validStartInput(String input) {
//    if (!input.toLowerCase().equals("yes") || !input.toLowerCase().equals("quit")
//        || !input.toLowerCase().equals("no")) {
//      System.out.println("Sorry, I don't understand. Please, type valid input.");
//      return false;
//    }
//    return true;
//  }

  private void startGame() {
    do {
      System.out.println("\n[Your current location is " + currentLocation.getName() + ".]");
      userMove();
    } while (true);
  }

  private void endGame() {
    System.out.println(
        "Are you sure you wish to exit the game?\nEnter 'yes' to exit and 'no' to return.");
    String input = userInput();
    if (input.equals("yes")) {
      System.out.println("Bye! See you later.");
      System.exit(0);
    } else if (input.equals("no")) {
      landingRoom();
    }
  }

  // parsing user input for the verb + noun
  // we can make function for each verb, and call the function in here


  private void userMove() {
    boolean validMove;
    String verb;
    String noun;

    do {
      noun = "";
      roomDescription(currentLocation);
      Inventory.displayItemsInInventory(currentInventory);
      System.out.println("\nWhat would you like to do next? ");
      String input = userInput();
      String[] arr = input.toLowerCase().split(" ");
      verb = arr[0];
      validMove = validMove(verb);
      if (arr.length == 2) {
        noun = arr[1];
      }
      if (wounded) {
        System.out.println("Please, use item to get out of the monster attack");
      }
    } while (!(validMove && validItem(noun)));
    if (verb.equals("help")) {
      userHelp();
    } else if (verb.equals("save")) {
      Inventory.saveInventoryToJson(currentInventory);
      gameMap.saveGameMaptoJson(gameMap);
      currentLocation.saveCurrentLocationToJson(currentLocation.getName());
    } else if (!wounded && verb.equals("go") || verb.equals("swim") || verb.equals("move")) {
      findLocationByDirection(noun.toLowerCase());
      itemsInRoom(currentLocation);
      wounded = checkMonster(currentLocation);
      if ("Medicine".equals(currentItem)) {
        controller.displayMedicineAsciiArt();
      }
      if ("Key".equals(currentItem)) {
        controller.displayKeyAsciiArt();
      }
      if ("Squid".equals(currentItem)) {
        controller.displaySquidAsciiArt();
      }
      if ("Cloak".equals(currentItem)) {
        controller.displayCloakAsciiArt();
      }
      if (playerWins()) {
        controller.displayPlayerWins();
        endGame();
      }

    } else if (verb.equals("get") && currentItem != null && noun.toLowerCase()
        .equals(currentItem.toLowerCase())) {
      sound.playGetItem();
      currentInventory = Inventory.addItemToInventory(currentItem);
      gameMap.removeItemFromRoom(gameMap, currentItem);
    } else if (verb.equals("use")) {
      sound.playUseItem();
      checkIfUserUsesCorrectItem(currentLocation, noun.toLowerCase());
    } else if (verb.equals("look") || verb.equals("examine")) {
      displayItemDescription(noun);
    } else if (verb.equals("learn")) {
      learnAboutRoom(currentLocation);
    } else if (verb.equals("talk") && noun.equals("turtle")) {
      checkIfUserUsesCorrectItem(currentLocation, noun.toLowerCase());
    } else if (verb.equals("quit")){
      endGame();
    } else {
      System.out.println("Please, check the commands. ");
    }
  }

  private void displayAsciiArt() {
    if ("guppy".equals(currentItem)) {
      controller.displayGuppyAsciiArt();
      controller.displayGuppyTalk();
      sound.playGuppy();
    }
    if ("Medicine".equals(currentItem)) {
      controller.displayMedicineAsciiArt();
    }
    if ("Key".equals(currentItem)) {
      controller.displayKeyAsciiArt();
    }
    if ("Squid".equals(currentItem)) {
      controller.displaySquidAsciiArt();
    }
    if ("Cloak".equals(currentItem)) {
      controller.displayCloakAsciiArt();
    }
    if (playerWins()) {
      controller.displayPlayerWins();
      endGame();
    }
  }


  private void checkIfUserUsesCorrectItem(Room location, String noun) {
    if (!currentInventory.isEmpty()) {
      if (noun.equals("squid") || noun.equals("medicine") || noun.equals("cloak")) {
        removeMonster(location, noun.toUpperCase());
        currentInventory = Inventory.removeItemFromInventory(currentInventory, noun.toUpperCase());
        wounded = false;
        System.out.println(noun);
        System.out.println(currentInventory);
      } else if (noun.equals("key")) {
        if (location.getName().equals("Engine Room")) {
          System.out.println(
              "You found Guppy. Now, you can go back to ths Ocean Floor with Guppy.");
          currentInventory.add(currentItem.toUpperCase());
          currentInventory.remove("KEY");
          controller.displayGuppyAsciiArt();
          controller.displayGuppyTalk();
          sound.playGuppy();
        } else {
          System.out.println("You can't use key here. You can use key to get Guppy.");
        }
      }
    }
    if (noun.equals("turtle")) {
      if (location.getName().equals("Bridge")) {
        controller.displayTurtleAsciiArt();
        turtleTalk();
      } else {
        System.out.println("You try to talk to the turtle, but the turtle is not in this room.");
      }
    } else {
      System.out.println("Your inventory doesn't have " + noun);
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
    }
    if (room != null) {
      setCurrentLocation(room);
    } else {
      System.out.println("Oops, there's nothing there in that direction.");
    }
  }


  public boolean checkMonster(Room currentLocation) {
    String goblinShark = "Goblin Shark";
    String jellyFish = "Jellyfish";
    String turtle = "Turtle";
    String monster = currentLocation.getAnimal();
    if (monster != null) {
      if (monster.equals(goblinShark)) {
        wounded = encounterMonster(goblinShark);
        System.out.println("Use medicine or cloak to get rid of monster.");
      } else if (monster.equals(jellyFish)) {
        wounded = encounterMonster(jellyFish);
      } else if (monster.equals(turtle)) {
        encounterMonster(turtle);
      }
    }
    return wounded;
  }

  private void removeMonster(Room location, String item) {
    String monster = location.getAnimal();
    if ("Goblin Shark".equals(monster)) {
      if ((item.equals("MEDICINE") && currentInventory.contains("MEDICINE")) || ((
          item.equals("SQUID") && currentInventory.contains("SQUID")))) {
        gameMap.removeAnimalFromRoom(gameMap, monster);
        System.out.println(monster + " is out of the way.");
      }
    }
    if ("Jellyfish".equals(monster)) {
      if ((item.equals("MEDICINE") && currentInventory.contains("MEDICINE")) || ((
          item.equals("CLOAK") && currentInventory.contains("CLOAK")))) {
        gameMap.removeAnimalFromRoom(gameMap, monster);
        System.out.println(monster + " is out of the way.");
      }
    } else {
      System.out.println("There's no monster here");
    }
  }


  // when the players go to the monster room, this function will be called.
  // This will check the user's inventory and if there's no item that can be used against moster,
  // the player will be sent back to the starting place.
  public boolean encounterMonster(String monster) {
    if (monster.equals("Goblin Shark")) {
      Learn.encounterGoblinSharkPrint();
      sound.playGoblinShark();
      controller.displayGoblinSharkAsciiArt();
      if (currentInventory.contains("MEDICINE")) {
        System.out.println("You can use your medicine to heal yourself.");
        wounded = true;
      } else if (currentInventory.contains("SQUID")) {
        System.out.println(
            "You can use squid from your inventory to blind the Goblin Shark with squid ink!");
        wounded = true;
      } else {
        System.out.println(
            "You are sent back to Ocean Floor.\n"
                + "You need to get medicine to heal yourself when encounter Goblin Shark, or a squid to sneak past the Goblin shark monster!\n");
        setCurrentLocation(startingLocation);
      }
    }
    if (monster.equals("Jellyfish")) {
      Learn.encounterJellyfishPrint();
      sound.playJellyfish();
      controller.displayJellyfishAsciiArt();
      if (currentInventory.contains("MEDICINE")) {
        System.out.println(
            "You can use your medicine to heal yourself.");
        wounded = true;
      } else if (currentInventory.contains("CLOAK")) {
        System.out.println(
            "You can use cloak to sneak past the Jellyfish monster!");
        wounded = true;
      } else {
        System.out.println(
            "You are sent back to Ocean Floor.\n"
                + "You need to get medicine to heal yourself when encounter Jellyfish, or a cloak to sneak past the Jellyfish monster!\n");
        setCurrentLocation(startingLocation);
      }
    }
    if (monster.equals("Turtle")) {
      controller.displayTurtleAsciiArt();
      System.out.println("There's a friendly turtle in this room, maybe they can help us!");
    }
    return wounded;
  }

  public static void roomDescription(Room location) {
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

  public static void displayItemDescription(String item) {
    Item.findDescription(item);
  }

  public boolean playerWins() {
    boolean playerWon = false;

    if (currentLocation.getName().equals(startingLocation) && currentInventory.contains("GUPPY")) {
      playerWon = true;
    }
    return playerWon;
  }

  public void userHelp() {
    controller.displayCommands();
  }

  public void turtleTalk() {
    controller.displayTurtleTalk();
  }

  // validate user's move input
  private static Boolean validMove(String move) {
    Set<String> moves = new HashSet<>(
        Arrays.asList("go", "swim", "move", "get", "grab", "look", "examine", "help", "talk", "use",
            "learn", "save", "quit"));
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
