package com.martin;

import java.util.Random;

public class Board {

  private int numRows = 10;
  private int numCols = 10;
  private int numMines = 10;

  private Cell[][] cells;

  //   public Board() {}

  public void init(int numMines) {
    //I guess we create a 2d array of cells and fill some with mines.. I wonder if there is a way to make every one of Alexs cells a mine? maybe by asking for a name?
    //this might help if we ever want to change the board size
    //this.numRows = numRows;
    //this.numCols = numCols;
    cells = new Cell[numRows][numCols];

    //put a cell into each spot on the array
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        cells[row][col] = new Cell(false);
      }
    }
    //add a bunch of mines which would be a 'type' of cell

    Random random = new Random();

    int minesPlaced = 0;
    //need to a add a check to make sure nummines is less or equal to columns * rows
    if (numMines > numCols * numCols) {
      numMines = numRows * numCols;
    }

    while (minesPlaced < numMines) {
      int row = random.nextInt(numRows);
      int col = random.nextInt(numCols);
      Cell cell = cells[row][col];

      if (!cell.isMine()) {
        cell.setMine(true);
        minesPlaced++;
      }
    }
    //count the adjacent mines on the board
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        Cell cell = cells[row][col];
        if (!cell.isMine()) {
          int adjacentMines = countAdjacentMines(row, col);
          cell.setAdjacentMines(adjacentMines);
        }
      }
    }
  }

  public int countAdjacentMines(int row, int col) {
    int count = 0;

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (
          i >= 0 && i < numRows && j >= 0 && j < numCols && cells[i][j].isMine()
        ) {
          count++;
        }
      }
    }
    return count;
  }

  public void draw() {
    System.out.print("  ");
    for (int col = 0; col < numCols; col++) {
      System.out.print(col + " ");
    }
    System.out.println();
    for (int row = 0; row < numRows; row++) {
      System.out.print(row + " ");
      for (int col = 0; col < numCols; col++) {
        Cell cell = cells[row][col];
        //if cell status is x do x else print .
        //cell.isRevealed()
        //midway figuring this out. using true to test the counting logic, which makes the else dead code at the moment
        if (cell.isRevealed()) {
          System.out.print(cell.displayValue() + " ");
        } else System.out.print(". ");
      }
      System.out.println();
    }
  }

  public boolean reveal(int row, int column) {
    Cell cell = cells[row][column];
    //so this needs to check whether or not the cell is a mine, whether the cell has been already revealed and then recursively reveal more cells (maybe)
    if (cell.isRevealed()) {
      return false;
    }
    cell.setRevealed(true);

    if (cell.isMine()) {
      exploded();
      return true; //and call exploded function
    }

    if (cell.getAdjacentMines() == 0) {
      for (
        int i = Math.max(0, row - 1);
        i <= Math.min(numRows - 1, row + 1);
        i++
      ) {
        for (
          int j = Math.max(0, column - 1);
          j <= Math.min(numCols - 1, column + 1);
          j++
        ) {
          if (i != row || j != column) {
            if (revealCell(i, j)) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  private boolean revealCell(int i, int j) {
    return false;
  }

  public boolean exploded() {
    return false;
  }
}
