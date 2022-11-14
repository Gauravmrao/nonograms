package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {

    // Initialized Encapsulated game info
    Model model = new ModelImpl(PuzzleLibrary.create());
    Controller controller = new ControllerImpl(model);
    stage.setTitle("Play Nonograms!");

    // Start Page
    BorderPane startPagePane = new BorderPane();
    startPagePane.setStyle(
        "-fx-background-color: linear-gradient(to bottom left, #66d9ff, #ff661a);");
    // Game Title
    HBox title = new HBox();
    Text titleText = new Text("NONOGRAMS");
    titleText.setFont(Font.font(70));
    title.getChildren().add(titleText);
    // Button to Start
    javafx.scene.control.Button startButton = new Button();
    startButton.setText("Click to Play Nonograms!");
    startButton.setOnAction(
        (ActionEvent event) -> {
          GamePageComponent gamePage = new GamePageComponent(controller);
          Scene gamePageScene = new Scene(gamePage.render(), 600, 600);
          stage.setScene(gamePageScene);
          stage.show();
        });
    startPagePane.setTop(title);
    startPagePane.setCenter(startButton);

    stage.setScene(new Scene(startPagePane, 600, 600));
    model.addObserver(
        (Model m) -> {
          stage.setScene(new Scene(new GamePageComponent(controller).render(), 600, 600));
        });

    // Show the Stage at the end of it all
    stage.show();
  }
}
