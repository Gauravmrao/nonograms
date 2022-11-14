package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TopCluesComponent implements FXComponent {

  private Controller controller;

  public TopCluesComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    GridPane topClues = new GridPane();
    topClues.setGridLinesVisible(true);
    Label placeholder = new Label("");
    placeholder.setPrefWidth(60);

    topClues.add(placeholder, 0, 0);

    for (int i = 0; i < controller.getClues().getWidth(); i++) {

      String clues = "    ";

      for (int j = 0; j < controller.getClues().getColCluesLength(); j++) {
        clues += controller.getClues().getColClues(i)[j] + "\n    ";
      }

      Label clue = new Label(clues);
      clue.setPrefWidth(31.616);
      topClues.add(clue, i + 1, 0);
    }

    return topClues;
  }
}
