package com.teamguppy.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class View {

  private final String GAME_TITLE =
      "   _____ _             _   _          _    _____                         \n"
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
      + "get/grab     [key, medicine, squid, cloak]\n"
      + "look/examine [key, medicine, squid, cloak]\n"
      + "use          [key, medicine, squid, cloak]\n"
      + "talk         [turtle]\n"
      + "learn        Displays educational information about a location or sea animal\n"
      + "help         Displays a list of game commands\n"
      + "save         Save the current game";

  private List<String> TURTLE_TALK = Arrays.asList(
      "\nAhh...a Startled Guppy you say?\n"
        + "Saw one flapping by no more than an hour ago heading south in a hurry.\n"
        + "But be careful...legend has it those who delve deeper into this ship don't always...return.",

      "I think I saw a wee little guppy...but I can't be quite sure...\n"
        + "My memory isn't very good these days.\n"
        + "Try talking to me again later and I might remember something.",

      "Guppies shouldn't be around here, you know?\n"
        + "However, I do recall seeing a Startled Guppy.\n"
        + "I believe they headed deeper into this sunk ship."
  );

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

  private final String GUPPY_TALK =
      "\nStartled Guppy: Daddy...Mommy, is, is that you?\n"
      + "Startled Guppy: It, it is you!\n"
      + "Startled Guppy: I've been rescued!";

  private final String GOBLIN_SHARK_ASCII_ART =
      " _________         .    .\n"
      + "(..       \\_    ,  |\\  /|\n"
      + " \\       O  \\  /|  \\ \\/ /\n"
      + "  \\______    \\/ |   \\  / \n"
      + "     vvvv\\    \\ |   /  |\n"
      + "     \\^^^^  ==   \\_/   |\n"
      + "      `\\_   ===    \\.  |\n"
      + "      / /\\_   \\ /      |\n"
      + "      |/   \\_  \\|      /\n"
      + "             \\________/\n";

  private final String JELLYFISH_ASCII_ART =
      "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣠⣤⣤⣤⣤⣄⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣶⠿⠛⠛⠋⠉⠁⠀⠀⠈⠉⠙⠛⠻⢿⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⢷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠿⠋⠀⢀⣴⣶⠶⢦⡀⠀⠀⠀⠀⠀⢀⣴⣶⠶⢦⡀⠀⠀⠀⠀⠙⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⠋⠀⠀⠀⣾⣿⣿⣀⣠⣧⠀⠀⠀⠀⠀⢸⣿⣿⣀⣠⡇⠀⠀⠀⠀⠀⠀⠙⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⢀⣾⠟⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠈⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⢀⣾⡏⠀⠀⠀⠀⠀⠀⠀⠙⠻⠟⠋⠀⠀⠀⠀⠀⠀⠀⠙⠻⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⡆⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⢠⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⢤⣄⣀⣤⡴⠞⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠘⣿⡆⠀⠀⠀⢸⡇⠀⠀⠀⢸⣇⠀⠀⠀⢀⣦⠀⠀⠀⢀⣶⡀⠀⠀⢀⣾⡀⠀⠀⠀⣼⡄⠀⠀⠀⣸⡿⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠘⢿⣦⣤⣴⠿⢿⣦⣤⣴⡿⠻⣶⣤⣴⣿⠻⣷⣤⣤⣾⣿⣷⣦⣤⣾⢿⣿⣦⣤⣾⠿⣿⣦⣤⣼⠟⠁⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⢀⣈⣽⠃⢀⣾⣿⠉⢹⣷⡀⠻⣏⠉⢹⡆⠀⠉⠁⣸⠏⠀⣽⠋⢠⣿⡇⠉⣿⢷⡀⠘⢿⣯⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⣴⠏⠉⠀⣠⣾⡿⠃⠀⡾⠛⣧⠀⠹⣆⠀⢻⡄⠀⢰⡏⠀⣸⠃⢀⡾⠋⢷⡀⠘⢿⣷⣤⣀⠀⠹⣧⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⢰⡏⠀⣼⠋⢉⡾⠁⢠⡾⠁⠀⢹⣇⠀⣿⠀⠸⡇⠀⣸⠃⠀⡿⠀⣼⠇⠀⠈⢿⡄⠈⢳⡀⠙⣧⠀⢹⡇⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⣾⠁⢀⡟⠀⡾⠁⢠⡿⠀⠀⠀⠀⣿⠀⢸⡇⠀⣿⠀⡿⠀⢸⡇⠀⣿⠀⠀⠀⠀⢻⡄⠈⢷⡀⢻⡄⠘⣷⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⢿⣦⣼⠇⣾⠁⢀⡿⠁⠀⠀⠀⢀⣿⠀⢸⣧⠀⠹⣿⠃⢀⣿⡇⠀⣿⡀⠀⠀⠀⠀⢿⡄⠈⣷⠘⣧⣴⠟⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⢸⡇⠀⠀⣠⡾⠛⠉⢀⣾⠻⣇⣰⠏⢀⣼⠋⢿⣄⠈⠙⢻⣆⠀⠀⢸⡇⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⢸⡇⠀⠀⣿⡀⠰⣾⠋⠁⠀⢹⣿⠀⢸⡇⠀⠀⠉⣿⠃⢠⡿⠀⠀⢸⡇⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡄⠘⣷⠀⠀⠸⣇⠀⢻⣄⠀⠀⢸⣷⠀⢸⡆⠀⠀⣰⠏⠀⣼⠃⠀⢀⡿⠀⢰⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣨⡷⠀⣸⡇⠀⠀⢹⡆⠀⢿⡀⢀⡾⢻⡄⠈⢷⡀⢠⡟⠀⣸⠇⠀⠀⠸⣧⠀⠻⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⣰⡟⠋⠁⣀⣴⠟⠀⠀⠀⠀⢻⡄⠈⣷⣼⠃⢀⣿⡀⠘⢧⣾⠀⢰⡏⠀⠀⠀⠀⠹⢷⣄⡀⠉⢻⡇⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠘⠿⠶⠞⠉⠁⠀⠀⠀⠀⢀⣸⡇⠀⣿⠃⢀⡾⠉⢿⡀⠘⣿⠀⠸⣧⣀⠀⠀⠀⠀⠀⠉⠙⠓⠟⠃⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⡛⠁⢀⣼⠃⢀⡾⠁⠀⣸⠇⢸⡟⢷⣄⠀⢙⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⠞⢻⡏⠀⣸⠇⠀⠀⡟⠀⢸⠃⠀⠉⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠁⢠⡟⠀⠀⠰⣇⠀⢸⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⠟⠀⣼⠇⠀⠀⠀⢻⣄⠀⠙⠳⢦⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠞⠛⢋⣁⣤⡴⠛⠁⠀⠀⠀⠀⠀⠉⠳⠦⣤⣀⣀⠈⠛⢶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠏⢀⡴⠞⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠙⢷⣄⠀⠹⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡄⠘⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⡀⠘⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠷⣴⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣻⡄⠘⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣀⣸⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
      + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠋⠀\n";

  private final String GUPPY_ASCII_ART =
      "\n               O  o\n"
      + "          _\\_   o\n"
      + ">('>   \\\\/  o\\ .\n"
      + "       //\\___=\n"
      + "          ''";

  private final String TURTLE_ASCII_ART =
      "                    __\n"
      + "         .,-;-;-,. /'_\\\n"
      + "       _/_/_/_|_\\_\\) /\n"
      + "     '-<_><_><_><_>=/\\\n"
      + "       `/_/====/_/-'\\_\\\n"
      + "        \"\"     \"\"    \"\"";

  private final String CLOAK_ASCII_ART =
      "⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣤⣴⣶⠞⠛⢶⣤⣄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄\n"
      + "⠄⠄⠄⠄⠄⣠⡶⠿⠿⠿⠿⠟⠁⣰⠇⣈⠻⣿⣿⣷⣶⣤⣀⠄⠄⠄⠄⠄\n"
      + "⠄⠄⠄⢠⣾⣿⡗⢿⣶⣶⣤⣴⣾⠟⢠⡏⠄⠄⠈⠙⠿⣿⣿⣷⣦⠄⠄⠄\n"
      + "⠄⠄⢠⣿⣿⣿⠇⢶⣤⣀⡺⠿⠋⣠⡾⠄⠄⢤⣶⣤⣄⠈⠛⢿⣿⣷⡄⠄\n"
      + "⠄⢀⣿⣿⣿⣣⣿⣷⣌⡛⢿⣿⣾⡟⠁⢤⣤⣀⠙⢿⣿⣷⣄⠄⠙⢿⣷⠄\n"
      + "⠄⣼⣿⣿⣳⣿⣿⣿⣿⣿⣷⣦⢭⣶⣇⠄⠻⣿⣧⡀⠙⢿⣿⣷⣦⡀⠙⠇\n"
      + "⢰⣿⣿⣳⣿⣿⣻⣿⢿⣿⣿⣿⣿⣿⣿⣷⡀⠹⣿⣿⣄⠄⠹⣿⣿⣴⡄⠄\n"
      + "⢸⡿⣱⣿⣿⣏⣿⣿⢸⣿⣿⣧⣿⣿⣿⣿⣷⡀⠘⣿⣿⣦⠄⠈⢿⡿⣱⣿\n"
      + "⠘⣵⣿⣿⣿⣸⣿⣿⢾⣿⣿⣿⢸⣿⣿⣿⣿⣷⠄⡜⣿⣿⣷⠄⠄⠁⣿⡿\n"
      + "⢸⣶⣍⢿⢧⣿⣿⣿⢸⣿⣿⣿⢸⣿⣿⣿⣿⣿⣇⠘⡜⣿⣷⣴⣦⣀⠘⠄\n"
      + "⠄⠻⣿⢇⣾⣿⣿⣿⢸⣿⣿⣿⡯⣿⣿⣿⣿⣿⣿⡆⠘⡽⡟⢫⣴⣶⡆⠄\n"
      + "⠄⠄⠙⢷⣿⡭⠡⠆⢸⣿⣿⣿⡇⠿⣿⣿⣿⣿⠛⠻⠄⢫⠄⣀⡹⣿⡇⠄\n"
      + "⠄⠄⠄⠄⠙⠃⠄⢀⣚⣭⣭⣭⡍⠄⣿⣿⣿⡿⢟⣛⣂⠄⣼⡿⣣⡟⠄⠄\n"
      + "⠄⠄⠄⠄⠄⠄⠉⠙⠻⣿⣿⣿⣁⣀⣈⣩⣭⣶⣿⣿⣿⣷⣭⡶⠋⠄⠄⠄";

  private final String MEDICINE_ASCII_ART =
      "              _________\n"
      + "             {_________}\n"
      + "              )=======(\n"
      + "             /         \\\n"
      + "            | _________ |\n"
      + "            ||   _     ||\n"
      + "            ||  |_)    ||\n"
      + "            ||  | \\/   ||\n"
      + "      __    ||    /\\   ||\n"
      + " __  (_|)   |'---------'|\n"
      + "(_|)        `-.........-'";

  private final String KEY_ASCII_ART =
      "    .---.\n"
      + "   /    |\\_______________\n"
      + "   |()  | _________  _   _)\n"
      + "   \\    |/        | | | |\n"
      + "    `---'         \"-\" |_|";

  private final String SQUID_ASCII_ART =
      "            ^\n"
      + "          /   \\\n"
      + "          \\   /\n"
      + "          |   |\n"
      + "          |   |\n"
      + "          | 0 |\n"
      + "         // ||\\\\\n"
      + "        (( // ||\n"
      + "         \\\\))  \\\\\n"
      + "       //||    ))\n"
      + "       ( ))   //\n"
      + "        //   ((";

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
    Collections.shuffle(TURTLE_TALK);
    return TURTLE_TALK.get(0);
  }

  public String getPlayerWins() {
    return PLAYER_WINS;
  }

  public String getGuppyTalk() {
    return GUPPY_TALK;
  }

  public String getGoblinSharkAsciiArt() {
    return GOBLIN_SHARK_ASCII_ART;
  }

  public String getJellyfishAsciiArt() {
    return JELLYFISH_ASCII_ART;
  }

  public String getGuppyAsciiArt() {
    return GUPPY_ASCII_ART;
  }

  public String getTurtleAsciiArt() {
    return TURTLE_ASCII_ART;
  }

  public String getCloakAsciiArt() {
    return CLOAK_ASCII_ART;
  }

  public String getMedicineAsciiArt() {
    return MEDICINE_ASCII_ART;
  }

  public String getKeyAsciiArt() {
    return KEY_ASCII_ART;
  }

  public String getSquidAsciiArt() {
    return SQUID_ASCII_ART;
  }
}
