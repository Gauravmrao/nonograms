# Nonograms

## Introduction

This project used a **model-view-controller** design pattern together with the **JavaFX** UI library to design a complete, functioning GUI implementation of the single-player logic puzzle **nonograms**.

If you've never heard of nonograms before, I highly suggest starting by checking out [the nonograms Wikipedia page](https://en.wikipedia.org/wiki/Nonogram). After you do that, [try solving a few nonogram puzzles](https://www.puzzle-nonograms.com/) yourself to make sure you've got the hang of it.

The user interacts with the game through the following:

1. If the user left-clicks on a cell, that cell becomes *shaded*. But, if they right-click on a cell, that cell becomes *eliminated*.

2. If the user left-clicks on an already-shaded cell, that cell returns to a blank state. If the user right-clicks on an already-eliminated cell, that cell should return to a blank state.

The puzzle is "solved" if the shaded squares match the clues. Non-shaded squares do not need to be labeled "eliminated" in order to solve the puzzle.


## Running the application

To run the application with Maven in IntelliJ, follow these steps:

1. Click the vertical "Maven" expansion tab which is on the right side of the IntelliJ window.

2. Expand the "Plugins" folder.

3. Expand the "javafx" folder.

4. Double-click "javafx:run" to run the project.


