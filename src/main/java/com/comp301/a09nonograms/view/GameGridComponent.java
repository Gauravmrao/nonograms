package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameGridComponent implements FXComponent {

  private Controller controller;

  public GameGridComponent(Controller control) {
    controller = control;
  }

  @Override
  public Parent render() {

    GridPane gameGrid = new GridPane();
    gameGrid.setGridLinesVisible(true);
    gameGrid.setVgap(2);
    gameGrid.setHgap(2);

    for (int i = 0; i < controller.getClues().getHeight(); i++) {

      for (int j = 0; j < controller.getClues().getWidth(); j++) {

        Rectangle box = new Rectangle();

        if (controller.isShaded(i, j)) {
          box = new Rectangle(30, 30, new Color(0, 0, 0, 1));
        } else if (controller.isEliminated(i, j)) {
          box = new Rectangle(30, 30, new Color(1, 0, 0, 1));
        } else {
          box = new Rectangle(30, 30, new Color(1, 1, 1, 1));
        }

        int finalI = i;
        int finalJ = j;
        box.setOnMousePressed(
            (MouseEvent e) -> {
              if (e.getButton() == MouseButton.PRIMARY) {
                controller.toggleShaded(finalI, finalJ);
              } else if (e.getButton() == MouseButton.SECONDARY) {
                controller.toggleEliminated(finalI, finalJ);
              }
            });

        gameGrid.add(box, j + 1, i);
      }
    }

    return gameGrid;
  }
}
