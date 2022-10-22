package com.teamguppy.controller;

import com.teamguppy.model.Game;
import com.teamguppy.view.Sound;
import com.teamguppy.view.View;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.simple.parser.ParseException;

public class Controller {

  private static Game game;
  private static View view;
  private static Sound sound;


  public Controller() {
  }

  public Controller(Game game, Sound sound, View view) {
    super();
    this.game = game;
    this.view = view;
    this.sound = sound;
  }

  public void checkSavedMap(){
    game.checkSavedGame();
  }
  public void landingRoom() throws IOException, ParseException, URISyntaxException {
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
}
