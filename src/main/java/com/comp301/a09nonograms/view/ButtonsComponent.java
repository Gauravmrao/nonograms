package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonsComponent implements FXComponent {

  private Controller controller;

  public ButtonsComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    Button prevPuzzle = new Button();
    prevPuzzle.setText("Previous Puzzle");
    prevPuzzle.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });

    Button nextPuzzle = new Button();
    nextPuzzle.setText("Next Puzzle");
    nextPuzzle.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });

    Button randPuzzle = new Button();
    randPuzzle.setText("Random Puzzle");
    randPuzzle.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });

    Button clearBoard = new Button();
    clearBoard.setText("Reset Puzzle");
    clearBoard.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
        });

    HBox gameControls = new HBox();
    gameControls.getChildren().addAll(prevPuzzle, nextPuzzle, randPuzzle, clearBoard);

    return gameControls;
  }
}
