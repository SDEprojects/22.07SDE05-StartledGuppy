package com.teamguppy.view;

public class View {

  private final String GAME_TITLE = "   _____ _             _   _          _    _____                         \n"
      + "  / ____| |           | | | |        | |  / ____|                        \n"
      + " | (___ | |_ __ _ _ __| |_| | ___  __| | | |  __ _   _ _ __  _ __  _   _ \n"
      + "  \\___ \\| __/ _` | '__| __| |/ _ \\/ _` | | | |_ | | | | '_ \\| '_ \\| | | |\n"
      + "  ____) | || (_| | |  | |_| |  __/ (_| | | |__| | |_| | |_) | |_) | |_| |\n"
      + " |_____/ \\__\\__,_|_|   \\__|_|\\___|\\__,_|  \\_____|\\__,_| .__/| .__/ \\__, |\n"
      + "                                                      | |   | |     __/ |\n"
      + "                                                      |_|   |_|    |___/ \n";

  private final String ABOUT_GAME =
      "=================== Welcome to Startled Guppy! – A text-based adventure game! ===================\n"
      + "Baby guppy was startled and ran away to a secret hiding spot.\n"
      + "As the parent, it’s your job to find baby guppy before baby guppy is lost forever!\n"
      + "Rescue the startled baby guppy to save the day and win the game!\n"
      + "Find items to sneak past monsters, open doors, and receive clues from a special turtle.\n"
      + "When the Startled Guppy is found, bring them back home to the Ocean Floor.\n";

  private final String COMMANDS = "=================== Game Commands ===================\n"
      + "go [north, south, east, west]\n"
      + "get [key, medicine, blood grenade, cloak]\n"
      + "use [key, medicine, blood grenade, cloak]\n"
      + "ask [turtle]\n"
      + "help - displays a list of game commands";

  public String getGameTitle() {
    return GAME_TITLE;
  }

  public String getAboutGame() {
    return ABOUT_GAME;
  }

  public String getCommands() {
    return COMMANDS;
  }




}
