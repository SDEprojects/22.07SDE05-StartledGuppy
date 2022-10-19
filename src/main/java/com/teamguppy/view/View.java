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
      + "When the Startled Guppy is found, bring them back home to the Ocean Floor.";

  private final String COMMANDS =
      "\n=================== Game Commands ===================\n"
      + "go/swim/move [north, south, east, west]\n"
      + "get/grab     [key, medicine, blood grenade, cloak]\n"
      + "look/examine [key, medicine, blood grenade, cloak]\n"
      + "use          [key, medicine, blood grenade, cloak]\n"
      + "talk         [turtle]\n"
      + "help         Displays a list of game commands";

  private final String TURTLE_TALK =
      "\nA...Startled Guppy you say?\n"
      + "Saw one flapping by no more than an hour ago heading south in a hurry.\n"
      + "But be careful...legend has it those who delve deeper into this ship don't always...return.";

  private final String PLAYER_WINS =
      " __     ______  _    _     __          _______ _   _   _ _ \n"
      + " \\ \\   / / __ \\| |  | |    \\ \\        / /_   _| \\ | | | | |\n"
      + "  \\ \\_/ / |  | | |  | |     \\ \\  /\\  / /  | | |  \\| | | | |\n"
      + "   \\   /| |  | | |  | |      \\ \\/  \\/ /   | | | . ` | | | |\n"
      + "    | | | |__| | |__| |       \\  /\\  /   _| |_| |\\  | |_|_|\n"
      + "    |_|  \\____/ \\____/         \\/  \\/   |_____|_| \\_| (_|_)\n"
      + "                                                           \n"
      + "                                                           \n"
      + "Startled Guppy has been rescued and you got them back home safely!";

  public String getGameTitle() {
    return GAME_TITLE;
  }

  public String getAboutGame() {
    return ABOUT_GAME;
  }

  public String getCommands() {
    return COMMANDS;
  }

  public String getTurtleTalk() {
    return TURTLE_TALK;
  }

  public String getPlayerWins() {
    return PLAYER_WINS;
  }




}
