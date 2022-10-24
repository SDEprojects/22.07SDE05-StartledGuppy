package com.teamguppy;

import com.teamguppy.controller.Controller;
import com.teamguppy.model.Game;
import com.teamguppy.view.Sound;
import com.teamguppy.view.View;
import java.net.URISyntaxException;


public class Main {

  public static void main(String[] args) {

    Game game = new Game();
    Sound sound = new Sound();
    View view = new View();
    Controller controller = new Controller(game, view, sound );

//    sound.playBackgroundMusic();
    controller.displayGameTitle();
    controller.displayAboutGame();
    controller.displayCommands();
    controller.checkSavedMap();
    try {
      controller.landingRoom();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
