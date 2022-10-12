package com.teamguppy.controller;

import com.teamguppy.view.View;

public class Controller {

  private static View view;

  public Controller(View view) {
    this.view = view;
  }

  public void displayAsciiBanner() {
    System.out.println(view.getAsciiBanner());
  }

}
