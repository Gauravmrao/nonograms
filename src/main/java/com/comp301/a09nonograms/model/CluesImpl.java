package com.comp301.a09nonograms.model;

public class CluesImpl implements Clues {

  private final int
      puzzleHeight; // The height of the puzzle (i.e. the number of rows in the puzzle)
  private final int
      puzzleWidth; // The width of the puzzle (i.e. the number of columns in the puzzle)
  private final int[][]
      clueRow; // An array of integers for each row in the puzzle, representing the clues for that
  // row
  private final int[][]
      clueColumn; // An array of integers for each column in the puzzle, representing the clues for
  // that column

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    puzzleHeight = rowClues.length;
    puzzleWidth = colClues.length;
    clueRow = rowClues;
    clueColumn = colClues;
  }

  @Override
  public int getWidth() {
    return puzzleWidth;
  }

  @Override
  public int getHeight() {
    return puzzleHeight;
  }

  @Override
  public int[] getRowClues(int index) {
    return clueRow[index];
  }

  @Override
  public int[] getColClues(int index) {
    return clueColumn[index];
  }

  @Override
  public int getRowCluesLength() {
    return clueRow[0].length;
  }

  @Override
  public int getColCluesLength() {
    return clueColumn[0].length;
  }
}
