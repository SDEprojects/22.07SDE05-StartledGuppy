package com.teamguppy.model;

import com.teamguppy.controller.Controller;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.parser.ParseException;

public class Game {


  private Location currentLocation;
  private ArrayList<String> currentInventory = new ArrayList<>();
  private Boolean wounded = false;
  private static final String startingLocation = "Ocean Floor";


  private static final String startingItem = "Medicine";
  public Game() {
    setCurrentInventory(startingItem);
    setCurrentLocation(startingLocation);
  }

  public ArrayList<String> getCurrentInventory() {
    return currentInventory;
  }

  private void setCurrentInventory(String item) {
    currentInventory.add(item);
  }
  private void setCurrentLocation(String location) {
    this.currentLocation = new Location(location);
  }



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
    String noun;
    do {
      noun = "";
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
    } else if (verb.equals("go") || verb.equals("swim") || verb.equals("move")) {
      findLocation(currentLocation.toString(), noun);
      if (currentLocation.toString().equals("Mariana Trench")) {
        System.out.println(getCurrentInventory());
        encounterMonster("Goblin Shark");
      }else if (currentLocation.toString().equals("Bedroom")){
        System.out.println(getCurrentInventory());
        encounterMonster("Jellyfish");
      }
      roomDescription(currentLocation.toString());
      itemsInRoom(currentLocation.toString());

    } else if (verb.equals("look") || verb.equals("examine")) {
      displayItemDescription(noun);
    } else if (verb.equals("use")) {
      // function for use
    } else{
      System.out.println("something not working ");
    }
  }

  public void findLocation(String location, String direction)
      throws URISyntaxException, IOException, ParseException {
    String newLocation = Location.findLocation(location, direction);
    setCurrentLocation(newLocation);
    System.out.println("Your current location " + currentLocation);
  }

  public void encounterMonster(String monster) {
    if (monster.equals("Goblin Shark")) {
      System.out.println("There’s a big scary Goblin Shark monster in here!");
      for (String item : currentInventory) {
        if (item.equals("Medicine")) {
          System.out.println(
              "You’ve taken some damage from the Goblin Shark, but you can use your medicine to heal yourself.");
          wounded = true;
          // need use item function here
        } else if (item.equals("Squid")) {
          System.out.println(" Use the use squid command to blind the Goblin Shark with squid ink!");
          wounded = true;
          // need use item function here
        } else {
          setCurrentLocation(startingLocation);
          System.out.println(
              "You've taken some damage from the Goblin Shark and fainted! \nYou were sent back to the Ocean Floor.");
          System.out.println("Your are now in " + currentLocation);
        }
      }
    }
    if (monster.equals("Jellyfish")) {
      System.out.println(
          "There’s a jiggly Jellyfish monster in this room!!  Oh, what should I do?!");
      for (String item : currentInventory){
        if (item.equals("Medicine")) {
          System.out.println(
              "The Jellyfish stung you and you took some damage, but you can use your medicine to heal yourself.");
          wounded = true;
          // need use item function here
        } else if (item.equals("Cloak")) {
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
    Set<String> moves = new HashSet<>(Arrays.asList("go", "swim", "move", "get", "grab", "look", "examine", "help", "ask"));
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