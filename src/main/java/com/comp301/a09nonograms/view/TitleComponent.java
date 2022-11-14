package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TitleComponent implements FXComponent {

  private Controller controller;

  public TitleComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    // Top Title
    HBox topText = new HBox();
    Text puzzleNum = new Text("Puzzle # " + (controller.getPuzzleIndex() + 1));
    puzzleNum.setFont(Font.font(30));
    topText.getChildren().add(puzzleNum);

    return topText;
  }
}
