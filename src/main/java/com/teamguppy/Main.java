package com.teamguppy;

import java.io.IOException;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {
    String location = "Ocean floor";
    try (Scanner sc = new Scanner(System.in)) {
      label:
      do {
        if (location.equals("Ocean floor")) {
          System.out.println("Welcome! enter yes to continue and quit to end");
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

  private static void startGame() {
    System.out.println("Enter go south to enter into new room");
    try(Scanner sc =  new Scanner(System.in)) {
      do {
        String command  =  sc.nextLine();
        switch (command) {
          case "go south":
            System.out.println("You are in ocean forest");
            break;
          case "go east":
            System.out.println("You are in sunk ship");
        }
      } while (true);
    }


  }

  private static void endGame() {
    System.out.println("Bye! See you later");

  }
}