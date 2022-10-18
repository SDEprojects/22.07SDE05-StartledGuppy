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
  private Inventory currentInventory;

  public Game() {
    Location startingLocation = new Location("Ocean Floor");
    Inventory startingInventory = new Inventory("");
    setCurrentLocation(startingLocation);
    setCurrentInventory(startingInventory);
  }

  private void setCurrentLocation(Location location) {
    this.currentLocation = location;
  }

  private void setCurrentInventory(Inventory inventory) { this.currentInventory = inventory;}


  public void landingRoom() throws IOException, ParseException, URISyntaxException {
    String command = null;
    try (Scanner sc = new Scanner(System.in)) {
      label:
      do {
        if (currentLocation.toString().equals("Ocean Floor")) {
          System.out.println("Enter 'yes' to continue and 'quit' to end the game.");
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
    String noun = "";
    do {
      System.out.println("What would you like to do? ");
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
    } else if (verb.equals("go")) {
      findLocation(currentLocation.toString(), noun);
      roomDescription(currentLocation.toString());
      itemsInRoom(currentLocation.toString());
    } else if (verb.equals("look")) {
      displayItemDescription(noun);
    } else{
      System.out.println("something not working ");
    }
  }

  public void findLocation(String location, String direction)
      throws URISyntaxException, IOException, ParseException {
    Location newLocation = Location.findLocation(location, direction);
    setCurrentLocation(newLocation);
    System.out.println("Your current location " + currentLocation);
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

  public static void userHelp() {
    Controller con = new Controller();
    con.displayCommands();
  }

  // validate user's move input

  private static Boolean validMove(String move) {

    if (move.equals("go") || move.equals("look") || move.equals("help") || move.equals("ask")) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands for valid move.");
      return false;
    }
  }


  private static Boolean validItem(String item) {
    Set<String> items = new HashSet<>(
        Arrays.asList("north", "south", "east", "west", "key", "medicine", "squid", "cloak",
            "turtle", ""));
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

