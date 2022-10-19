package com.teamguppy.controller;

import com.teamguppy.model.Game;
import com.teamguppy.view.View;

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
