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
    // this.numRows = numRows;
    // this.numCols = numCols;
    cells = new Cell[numRows][numCols];

    //put a cell into each spot on the array
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        cells[row][col] = new Cell();
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

        if (cell.isMine()) { //just for testing
          System.out.print("X ");
        } else if (cell.isRevealed()) {
          System.out.print(cell.displayValue() + " ");
        } else System.out.print(". ");
      }
      System.out.println();
    }
  }

  public void reveal(int row, int column) {
    //so this needs to check whether or not the cell is a mine
  }

  public boolean exploded() {
    return false;
  }
}
