package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private ArrayList<Puzzle>
      puzzleList; // A library of available nonogram puzzles for the user to solve
  private int
      activePuzzleIndex; // A way to select which puzzle is currently active; for example, maybe an
  // index into the puzzle library
  private ArrayList<ModelObserver>
      activeObservers; // A List<ModelObserver> of active model observers, represented by the
  // ModelObserver interface (see below)

  public ModelImpl(List<Clues> clues) {
    puzzleList = new ArrayList<Puzzle>(0);

    for (Clues clue : clues) {
      puzzleList.add(new PuzzleImpl(clue));
    }
    activePuzzleIndex = 0;
    activeObservers = new ArrayList<ModelObserver>(0);
  }

  @Override
  public int getPuzzleCount() {
    return puzzleList.size();
  }

  @Override
  public int getPuzzleIndex() {
    return activePuzzleIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    activePuzzleIndex = index;

    for (ModelObserver modelObserver : activeObservers) {
      modelObserver.update(this);
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    activeObservers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    activeObservers.remove(observer);
  }

  @Override
  public boolean isSolved() {
    Puzzle currentPuzzle = puzzleList.get(activePuzzleIndex);
    Board currentBoard = currentPuzzle.getBoard();
    CluesImpl currentClues = currentPuzzle.getClues();

    // Goes through Row by Row
    for (int i = 0; i < currentClues.getHeight(); i++) {
      ArrayList<Integer> nonZeroClues = new ArrayList<Integer>(0);

      // Selects each clue in each row
      for (int j = 0; j < currentClues.getRowClues(i).length; j++) {

        // Adds each nonzero clue to an array for comparison
        if (currentClues.getRowClues(i)[j] != 0) {
          nonZeroClues.add(currentClues.getRowClues(i)[j]);
        }
      }

      // Goes through the row on the board and adds all blocks to an array for comparison.
      int rowCounter = 0;
      ArrayList<Integer> blockContainer = new ArrayList<Integer>(0);

      for (int k = 0; k < currentClues.getWidth(); k++) {
        if (currentBoard.isShaded(i, k)) {
          rowCounter += 1;
        } else {
          if (rowCounter != 0) {
            blockContainer.add(rowCounter);
            rowCounter = 0;
          }
        }
      }
      if (rowCounter != 0) {
        blockContainer.add(rowCounter);
      }

      // Compares the two arrays for validity.
      for (int m = 0; m < nonZeroClues.size(); m++) {
        if (!blockContainer.contains(nonZeroClues.get(m))) {
          return false;
        } else {
          blockContainer.remove(nonZeroClues.get(m));
        }
      }
      if (blockContainer.size() != 0) {
        return false;
      }
    }

    // Goes through Column by Column
    for (int i = 0; i < currentClues.getWidth(); i++) {
      ArrayList<Integer> nonZeroClues = new ArrayList<Integer>(0);

      // Selects each clue in each column
      for (int j = 0; j < currentClues.getColClues(i).length; j++) {

        // Adds each nonzero clue to an array for comparison
        if (currentClues.getColClues(i)[j] != 0) {
          nonZeroClues.add(currentClues.getColClues(i)[j]);
        }
      }

      // Goes through the row on the board and adds all blocks to an array for comparison.
      int colCounter = 0;
      ArrayList<Integer> blockContainer = new ArrayList<Integer>(0);

      for (int k = 0; k < currentClues.getHeight(); k++) {
        if (currentBoard.isShaded(k, i)) {
          colCounter += 1;
        } else {
          if (colCounter != 0) {
            blockContainer.add(colCounter);
            colCounter = 0;
          }
        }
      }
      if (colCounter != 0) {
        blockContainer.add(colCounter);
      }

      // Compares the two arrays for validity.
      for (int m = 0; m < nonZeroClues.size(); m++) {
        if (!blockContainer.contains(nonZeroClues.get(m))) {
          return false;
        } else {
          blockContainer.remove(nonZeroClues.get(m));
        }
      }
      if (blockContainer.size() != 0) {
        return false;
      }
    }

    // Tests if each ROW has been solved
    for (int i = 0; i < currentClues.getHeight(); i++) {
      int clueCounter = 0;
      for (int j = 0; j < currentClues.getRowClues(i).length; j++) {
        clueCounter += currentClues.getRowClues(i)[j];
      }

      int boardCounter = 0;
      for (int k = 0; k < currentClues.getWidth(); k++) {
        if (currentBoard.isShaded(i, k)) {
          boardCounter += 1;
        }
      }

      if (clueCounter != boardCounter) {
        return false;
      }
    }

    // Tests if each COLUMN has been solved
    for (int i = 0; i < currentClues.getWidth(); i++) {
      int clueCounter = 0;
      for (int j = 0; j < currentClues.getColClues(i).length; j++) {
        clueCounter += currentClues.getColClues(i)[j];
      }

      int boardCounter = 0;
      for (int k = 0; k < currentClues.getHeight(); k++) {
        if (currentBoard.isShaded(k, i)) {
          boardCounter += 1;
        }
      }

      if (clueCounter != boardCounter) {
        return false;
      }
    }

    return true;
  }

  // Inherited from Board
  @Override
  public boolean isShaded(int row, int col) {
    return puzzleList.get(activePuzzleIndex).getBoard().isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzleList.get(activePuzzleIndex).getBoard().isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzleList.get(activePuzzleIndex).getBoard().isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzleList.get(activePuzzleIndex).getBoard().toggleCellShaded(row, col);

    for (ModelObserver modelObserver : activeObservers) {
      modelObserver.update(this);
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzleList.get(activePuzzleIndex).getBoard().toggleCellEliminated(row, col);

    for (ModelObserver modelObserver : activeObservers) {
      modelObserver.update(this);
    }
  }

  @Override
  public void clear() {
    puzzleList.get(activePuzzleIndex).getBoard().clear();

    for (ModelObserver modelObserver : activeObservers) {
      modelObserver.update(this);
    }
  }

  // Inherited from Clues
  @Override
  public int getWidth() {
    return puzzleList.get(activePuzzleIndex).getClues().getWidth();
  }

  @Override
  public int getHeight() {
    return puzzleList.get(activePuzzleIndex).getClues().getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return puzzleList.get(activePuzzleIndex).getClues().getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return puzzleList.get(activePuzzleIndex).getClues().getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return puzzleList.get(activePuzzleIndex).getClues().getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return puzzleList.get(activePuzzleIndex).getClues().getColCluesLength();
  }
}
