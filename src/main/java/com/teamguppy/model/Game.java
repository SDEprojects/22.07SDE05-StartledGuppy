package com.teamguppy.model;

import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

public class Game {

  private static Location currentLocation;

  public Game() {
    currentLocation = new Location("Ocean Floor");
  }

  public static void landingRoom() throws IOException, ParseException {

    try (Scanner sc = new Scanner(System.in)) {
      label:
      do {
        if (currentLocation.toString().equals("Ocean Floor")) {
          System.out.println("Welcome! enter 'yes' to continue and 'quit' to end the game.");
          String command = sc.nextLine();
          switch (command) {
            case "yes":
              startGame();
              break label;
            case "quit":
              endGame();
              break label;
          }
        }
      } while (true);
    }
  }

  private static void startGame() throws IOException, ParseException {
    userMove();
    System.out.println("Enter 'go south' or 'go east' or 'go west' to enter into new room.");
    try (Scanner sc = new Scanner(System.in)) {
      do {
        String command = sc.nextLine();
        switch (command) {
          case "go south":
            System.out.println("You are in ocean forest.");
            break;
          case "go east":
            System.out.println("You are in sunk ship.");
            break;
          case "go west":
            System.out.println("You have encountered a goblin shark.");
        }
      } while (true);
    }
  }

  private static void endGame() throws IOException, ParseException {
    System.out.println(
        "Are you sure you wish to exit the game?\nEnter 'yes' to exit and 'no' to return.");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    if (input.equals("yes")) {
      System.out.println("Bye! See you later.");

    } else if (input.equals("no")) {
      landingRoom();
    }
  }

  // parsing user input for the verb + noun
  // we can make function for each verb, and call the function in here
  private static void userMove() throws IOException, ParseException {
    System.out.println("What would you like to do? ");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String arr[] = input.toLowerCase().split(" ", 2);

    String move = arr[0];
    String item = arr[1];
    System.out.println(move);
    if (move.equals("go")){
      currentLocation = Location.findLocation(currentLocation.toString(), item);
      //function for go
      System.out.println("Your current location " + currentLocation);

    }else if(move.equals("look")){
      System.out.println("not working");
      //function for look
    }

  }
}

