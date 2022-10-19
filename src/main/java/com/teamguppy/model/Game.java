package com.teamguppy.model;

import com.teamguppy.controller.Controller;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.parser.ParseException;

public class Game {


  private static Location currentLocation;
  private Controller con = new Controller();
//  private ArrayList<String> currentInventory1 = new ArrayList<>();
  private Boolean wounded = false;
  private static final String startingLocation = "Ocean Floor";
  private Set<String> currentInventory;


  private static final String startingItem = "Medicine";
  public Game() {
    String startingLocation = "Ocean Floor";
    setCurrentLocation(startingLocation);
    this.currentInventory = new HashSet<>();
  }

//  public ArrayList<String> getCurrentInventory1() {
//    return currentInventory1;
//  }

//  private void setCurrentInventory(String item) {
//    currentInventory.add(item);
//  }
  private void setCurrentLocation(String location) {
    this.currentLocation = new Location(location);
  }
  public void setCurrentInventory(Set<String> currentInventory) {
    this.currentInventory = currentInventory;

  }

  public static Location getCurrentLocation() {
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
        if (currentLocation.toString().equals("Ocean Floor")) {
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
      System.out.println("\nWhat would you like to do? ");
      String input = userInput();
      String[] arr = input.toLowerCase().split(" ");
      verb = arr[0];
      validMove = validMove(verb);
      if (arr.length == 2) {
        noun = arr[1];
      }
    } while (!(validMove && validItem(noun)));
      if (verb.equals("help")) {
      userHelp();
    } else if (verb.equals("go") || verb.equals("swim") || verb.equals("move")) {

        findLocation(currentLocation.toString(), noun);
      // checking if the player enter the location with monster, and if so, call the encounterMonster function.
        checkMonster(currentLocation.toString());
        roomDescription(currentLocation.toString());
        itemsInRoom(currentLocation.toString());
        Inventory.displayItemsInInventory();
    } else if (verb.equals("get")) {
        currentInventory = Inventory.addItemToInventory(currentLocation.toString());
        System.out.println(currentInventory);
      } else if (verb.equals("use")) {
        currentInventory = Inventory.removeItemFromInventory(noun);
        System.out.println(currentInventory);
      } else if (verb.equals("look") || verb.equals("examine")) {
      displayItemDescription(noun);

    } else if (verb.equals("talk") && noun.equals("turtle")) {
      turtleTalk();
    } else {
      System.out.println("You try to talk to the " + noun + ", but the " + noun + " doesn't talk back...");
    }
  }


  public void findLocation(String location, String direction)
      throws URISyntaxException, IOException, ParseException {
    Location newLocation = Location.findLocation(location, direction);
    setCurrentLocation(newLocation.toString());
    System.out.println("\nYour current location is " + currentLocation);
  }

  // checks if the player entered the monster room
  private void checkMonster(String location) {
    if (currentLocation.toString().equals("Mariana Trench")) {
      encounterMonster("Goblin Shark");
    }else if (currentLocation.toString().equals("Bedroom")){
      encounterMonster("Jellyfish");
    }
  }

  // when the players go to the monster room, this function will be called.
  // This will check the user's inventory and if there's no item that can be used against moster,
  // the player will be sent back to the starting place.
  public void encounterMonster(String monster) {
    if (monster.equals("Goblin Shark")) {
      System.out.println("There’s a big scary Goblin Shark monster in here!");
      if (currentInventory.contains("medicine")) {
        System.out.println("You’ve taken some damage from the Goblin Shark, but you can use your medicine to heal yourself.");
        wounded = true;
        // need use item function here
      } else if (currentInventory.contains("squid")) {
        System.out.println(" Use the use squid command to blind the Goblin Shark with squid ink!");
        wounded = true;
        // need use item function here
      } else {
        setCurrentLocation(startingLocation);
        System.out.println("You've taken some damage from the Goblin Shark and fainted! \nYou were sent back to the Ocean Floor.");
        System.out.println("Your are now in " + currentLocation);
      }
    }

    if (monster.equals("Jellyfish")) {
      System.out.println("There’s a jiggly Jellyfish monster in this room!!  Oh, what should I do?!");

      if (currentInventory.contains("medicine")) {
        System.out.println(
            "The Jellyfish stung you and you took some damage, but you can use your medicine to heal yourself.");
        wounded = true;
        // need use item function here
      } else if (currentInventory.contains("cloak")) {
        System.out.println(
            "The Jellyfish stung you and you took some damage! Use the use cloak command to sneak past the Jellyfish monster!");
        wounded = true;
        // need use item function here
      } else {
        System.out.println(
            "You’ve fainted and were sent back to the Ocean Floor.\n Find an item to heal yourself, or an item to sneak past the Jellyfish monster!\n");
        setCurrentLocation(startingLocation);
        System.out.println("Your are now in " + currentLocation);
      }
    }
  }

  public static void roomDescription(String location)
      throws IOException, ParseException, URISyntaxException {
    Location.roomDescription(location);
  }

  public void itemsInRoom(String location)
      throws IOException, ParseException, URISyntaxException {
    Location.itemsInRoom(location);
  }

  public static void displayItemDescription(String item) throws IOException, ParseException {
    Item.findDescription(item);
  }

  public void userHelp() {
    con.displayCommands();
  }

  public void turtleTalk() {
    con.displayTurtleTalk();
  }

  // validate user's move input
  private static Boolean validMove(String move) {
    Set<String> moves = new HashSet<>(Arrays.asList("go", "swim", "move", "get", "grab", "look", "examine", "help", "talk", "use"));
    if (moves.contains(move)) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands for valid move.");
      return false;
    }
  }

  private static Boolean validItem(String item) {
    Set<String> items = new HashSet<>(
        Arrays.asList("north", "south", "east", "west", "key", "medicine", "squid", "cloak", "turtle", ""));
    if (items.contains(item)) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands for valid item.");
      return false;
    }
  }

  private static String userInput() {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    return input;
  }
}

