package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

  // 0 in the cell means space
  // 1 in the cell means shaded
  // 2 in the cell means eliminated with an "x"

  private int[][] board;

  public BoardImpl(int[][] boardy) {
    board = boardy;
  }

  @Override
  public boolean isShaded(int row, int col) {

    return board[row][col] == 1;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return board[row][col] == 2;
  }

  @Override
  public boolean isSpace(int row, int col) {
    return board[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (board[row][col] == 1) {
      board[row][col] = 0;
    } else {
      board[row][col] = 1;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (board[row][col] == 2) {
      board[row][col] = 0;
    } else {
      board[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = 0;
      }
    }
  }
}
