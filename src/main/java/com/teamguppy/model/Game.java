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


  private Location currentLocation;
  private Set<String> currentInventory;

  private static Location currentLocation;
  // private Inventory currentInventory;
  private Controller con = new Controller();


  public Game() {
    Location startingLocation = new Location("Ocean Floor");
    Inventory startingInventory = new Inventory("");
    setCurrentLocation(startingLocation);
//    setCurrentInventory(startingInventory);
  }

  private static void setCurrentLocation(Location location) {
    currentLocation = location;
  }


  public void setCurrentInventory(Set<String> currentInventory) {
    this.currentInventory = currentInventory;
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
      roomDescription(currentLocation.toString());
      itemsInRoom(currentLocation.toString());
      Inventory.displayItemsInInventory();
    } else if (verb.equals("get")) {
      currentInventory = Inventory.addItemToInventory(currentLocation.toString());
      System.out.println(currentInventory);
    } else if (verb.equals("use")) {
      currentInventory = Inventory.removeItemFromInventory(noun);
      System.out.println(currentInventory);
    } else if (verb.equals("look")) {
      displayItemDescription(noun);
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
    setCurrentLocation(newLocation);
    System.out.println("\nYour current location " + currentLocation);
  }

  public static void roomDescription(String location)
      throws IOException, ParseException, URISyntaxException {
    Location.roomDescription(location);
  }

  public static void itemsInRoom(String location)
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
    Set<String> moves = new HashSet<>(Arrays.asList("go", "swim", "move", "get", "grab", "look", "examine", "help", "talk"));
    if (moves.contains(move)) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands for valid move.");
      return false;
    }
  }

  private static Boolean validItem(String item) {
    Set<String> items = new HashSet<>(
        Arrays.asList("north", "south", "east", "west", "key", "medicine", "squid", "cloak",
            "turtle", "inventory", ""));
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

