package com.teamguppy.model;

import com.teamguppy.controller.Controller;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import org.json.simple.parser.ParseException;

public class Game {

  private static Location currentLocation;

  public Game() {
    Location startingLocation = new Location("Ocean Floor");
    setCurrentLocation(startingLocation);
  }

  private void setCurrentLocation(Location location) {
    this.currentLocation = location;
  }

  public static Location getCurrentLocation() {
    return currentLocation;
  }


  public static void landingRoom() throws IOException, ParseException {
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

  private static void startGame() throws IOException, ParseException {
    do {
      userMove();
    } while (true);
  }


  private static void endGame() throws IOException, ParseException {

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

  private static void userMove() throws IOException, ParseException {
    boolean valid;
    String move;
    String item = "";

    do {
      System.out.println("What would you like to do? ");
      String input = userInput();
      String[] arr = input.toLowerCase().split(" ");
      move = arr[0];
      valid = validMove(move);

//      System.out.println(valid);
    } while (!valid);
    if (move.equals("go")) {

      if (arr.length == 2) {
        item = arr[1];
      }
    } while(!(valid && validItem(item)));
    if (move.equals("help")) {
      userHelp();
    } else if (move.equals("go")) {
     currentLocation = Location.findLocation(currentLocation.toString(), item);
      //function for go
      currentLocation = Location.findLocation(currentLocation.toString(), item);
      System.out.println("Your current location " + currentLocation);
      Location.roomDescription(currentLocation.toString());
    } else if (move.equals("look")) {
      System.out.println("not working");
      //function for look
    }

  }

  public static void userHelp() {
    Controller con = new Controller();
    con.displayCommands();
  }

  // validate user's move input

  private static Boolean validMove(String move) {
    System.out.println("this " + move);

    if (move.equals("go") || move.equals("look") || move.equals("help") || move.equals("ask")) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands.");
    }
    return false;
  }



  private static Boolean validItem(String item) {
    Set<String> items = new HashSet<>(Arrays.asList("north", "south", "east", "west", "key", "medicine", "blood grenade", "cloak", "turtle", ""));
    if (items.contains(item)) {
      return true;
    } else {
      System.out.println("Sorry, I don't understand. Please check the Game Commands.");
      return false;
    }
  }

  private static String userInput() {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    return input;
  }
}

