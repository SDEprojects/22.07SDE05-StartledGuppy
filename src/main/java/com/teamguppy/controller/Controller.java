package com.teamguppy.controller;

import com.teamguppy.model.Game;
import com.teamguppy.view.View;
import java.io.IOException;
import java.net.URISyntaxException;
import org.json.simple.parser.ParseException;

public class Controller {
  private static Game game;

  private static View view;

  public Controller() {

  }

  public Controller(Game game, View view) {
    super();
    this.game = game;
    this.view = view;
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
    System.out.println(view.getTurtleTalk());
  }

}
