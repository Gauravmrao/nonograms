package com.comp301.a09nonograms.model;

public class PuzzleImpl implements Puzzle {

  private CluesImpl clues;
  private BoardImpl board;

  public PuzzleImpl(Clues clue) {
    clues = (CluesImpl) clue;
    board = new BoardImpl(new int[clues.getHeight()][clues.getWidth()]);
    board.clear();
  }

  public BoardImpl getBoard() {
    return board;
  }

  @Override
  public CluesImpl getClues() {
    return clues;
  }
}
