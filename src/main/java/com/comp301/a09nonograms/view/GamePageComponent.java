package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GamePageComponent implements FXComponent {
  private Controller controller;

  public GamePageComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    // Top Title
    TitleComponent title = new TitleComponent(controller);

    // Clues
    SideCluesComponent sideClues = new SideCluesComponent(controller);
    TopCluesComponent topClues = new TopCluesComponent(controller);

    // Game
    GameGridComponent gameGrid = new GameGridComponent(controller);

    // Check to see if a puzzle has been solved
    FinishedPuzzleComponent solvedPuzzle = new FinishedPuzzleComponent(controller);

    // Buttons
    ButtonsComponent buttons = new ButtonsComponent(controller);

    // Main Game
    VBox top = new VBox();
    HBox toppest = new HBox();
    toppest.setStyle("-fx-background-color: linear-gradient(to bottom left, #8080ff, #d9ff66);");
    toppest.getChildren().add(title.render());
    top.getChildren().add(toppest);
    top.getChildren().add(topClues.render());

    BorderPane gamePagePane = new BorderPane();
    gamePagePane.setTop(top);
    gamePagePane.setLeft(sideClues.render());
    gamePagePane.setCenter(gameGrid.render());
    gamePagePane.setRight(solvedPuzzle.render());

    VBox bottom = new VBox();
    HBox bottomest = new HBox();
    bottomest.prefHeight(60);
    bottom.setStyle("-fx-background-color: linear-gradient(to bottom left, #ffff00, #66a3ff);");
    bottom.getChildren().add(buttons.render());
    bottom.getChildren().add(bottomest);
    gamePagePane.setBottom(bottom);

    return gamePagePane;
  }
}
