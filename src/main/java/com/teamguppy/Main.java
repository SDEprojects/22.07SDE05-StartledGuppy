package com.teamguppy;

import com.teamguppy.controller.Controller;
import com.teamguppy.view.View;

public class Main {

  public static void main(String[] args) {
    View view = new View();
    Controller controller = new Controller(view);
    controller.displayAsciiBanner();

  }
}
