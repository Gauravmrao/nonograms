package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SideCluesComponent implements FXComponent {

  private Controller controller;

  public SideCluesComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    GridPane sideClues = new GridPane();
    sideClues.setGridLinesVisible(true);

    for (int i = 0; i < controller.getClues().getHeight(); i++) {

      String clues = "  ";

      for (int j = 0; j < controller.getClues().getRowCluesLength(); j++) {
        clues += controller.getClues().getRowClues(i)[j] + "  ";
      }

      Label clue = new Label(clues);
      clue.setPrefHeight(31.616);
      clue.setPrefWidth(60);
      sideClues.add(clue, 0, i);
    }

    return sideClues;
  }
}
