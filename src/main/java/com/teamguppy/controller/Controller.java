package com.teamguppy.controller;

import com.teamguppy.model.Game;
import com.teamguppy.view.Sound;
import com.teamguppy.view.View;
import java.net.URISyntaxException;

public class Controller {

  private static Game game;
  private static View view;
  private static Sound sound;


  public Controller() {
  }

  public Controller(Game game, View view, Sound sound) {
    super();
    this.game = game;
    this.view = view;
    this.sound = sound;
  }

  public void checkSavedMap(){
    game.checkSavedGame();
  }
  public void landingRoom() throws  URISyntaxException {
    game.landingRoom();
  }

  public void displayGameTitle() {
    System.out.println(view.getGameTitle());
  }

  public void displayAboutGame() {
    System.out.println(view.getAboutGame());
  }

  public void displayCommands() {
    System.out.println(view.getCommands());
  }

  public void displayTurtleTalk() {
    String result = view.getTurtleTalk();
    System.out.println(result);
    if (result.startsWith("\nAhh")) {
      sound.playTurtleTalk0();
    } else if (result.startsWith("I")) {
      sound.playTurtleTalk1();
    } else if (result.startsWith("Guppies")) {
      sound.playTurtleTalk2();
    }
  }

  public void displayPlayerWins() {
    System.out.println(view.getPlayerWins());
  }

  public void playBackgroundMusic() {
    sound.playBackgroundMusic();
  }

  public void displayGuppyTalk() {
    System.out.println(view.getGuppyTalk());
  }

  public void displayGoblinSharkAsciiArt() {
    System.out.println(view.getGoblinSharkAsciiArt());
  }

  public void displayJellyfishAsciiArt() {
    System.out.println(view.getJellyfishAsciiArt());
  }

  public void displayGuppyAsciiArt() {
    System.out.println(view.getGuppyAsciiArt());
  }

  public void displayTurtleAsciiArt() {
    System.out.println(view.getTurtleAsciiArt());
  }

  public void displayCloakAsciiArt() {
    System.out.println(view.getCloakAsciiArt());
  }

  public void displayMedicineAsciiArt() {
    System.out.println(view.getMedicineAsciiArt());
  }

  public void displayKeyAsciiArt() {
    System.out.println(view.getKeyAsciiArt());
  }

  public void displaySquidAsciiArt() {
    System.out.println(view.getSquidAsciiArt());
  }
}
