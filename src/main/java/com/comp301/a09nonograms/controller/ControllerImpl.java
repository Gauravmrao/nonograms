package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.CluesImpl;
import com.comp301.a09nonograms.model.Model;

public class ControllerImpl implements Controller {

  private Model model;

  public ControllerImpl(Model model) {
    if (model == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
  }

  @Override
  public Clues getClues() {

    int[][] rows = new int[model.getHeight()][model.getRowCluesLength()];
    int[][] cols = new int[model.getWidth()][model.getColCluesLength()];

    for (int i = 0; i < model.getHeight(); i++) {
      rows[i] = model.getRowClues(i);
    }
    for (int i = 0; i < model.getWidth(); i++) {
      cols[i] = model.getColClues(i);
    }

    return new CluesImpl(rows, cols);
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    int newPuzzle = model.getPuzzleIndex() + 1;
    if (newPuzzle == model.getPuzzleCount()) {
      newPuzzle = model.getPuzzleCount() - 1;
    }
    model.setPuzzleIndex(newPuzzle);
  }

  @Override
  public void prevPuzzle() {
    int newPuzzle = model.getPuzzleIndex() - 1;
    if (newPuzzle == -1) {
      newPuzzle = 0;
    }
    model.setPuzzleIndex(newPuzzle);
  }

  @Override
  public void randPuzzle() {
    int newPuzzle = (int) (Math.random() * model.getPuzzleCount());
    model.setPuzzleIndex(newPuzzle);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
