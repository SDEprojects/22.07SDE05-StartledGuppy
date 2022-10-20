package com.teamguppy;

import com.teamguppy.controller.Controller;
import com.teamguppy.model.Game;
import com.teamguppy.view.Sound;
import com.teamguppy.view.View;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.simple.parser.ParseException;


public class Main {

  public static void main(String[] args) throws IOException, ParseException {

    Game game = new Game();
    View view = new View();

    Sound sound = new Sound();
    sound.playSound();


    Controller controller = new Controller(game, view);
    controller.displayGameTitle();
    controller.displayAboutGame();
    controller.displayCommands();
    try {
      controller.landingRoom();
    } catch (IOException e) {
      System.out.println(e);
    } catch (ParseException e) {
      System.out.println(e);
    } catch (URISyntaxException e) {
      System.out.println(e);
    }
  }
}
