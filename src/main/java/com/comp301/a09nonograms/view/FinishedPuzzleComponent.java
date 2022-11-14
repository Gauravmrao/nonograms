package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FinishedPuzzleComponent implements FXComponent {

  private Controller controller;

  public FinishedPuzzleComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    VBox finishedMessage = new VBox();
    if (controller.isSolved()) {
      Text solved = new Text("You've \n Successfully \n completed \n this Nonogram \n puzzle!");
      solved.setFont(Font.font(30));
      finishedMessage.getChildren().add(solved);
    }

    return finishedMessage;
  }
}
