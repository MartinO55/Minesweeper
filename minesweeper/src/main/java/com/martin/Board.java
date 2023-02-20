package com.martin;

public class Board {

  private int numRows = 10;
  private int numCols = 10;
  private Cell[][] cells;

  //   public Board() {}

  public void init() {
    //I guess we create a 2d array of cells and fill some with mines.. I wonder if there is a way to make every one of Alexs cells a mine? maybe by asking for a name?
    //this might help if we ever want to change the board size
    this.numRows = numRows;
    this.numCols = numCols;
    cells = new Cell[numRows][numCols];

    //put a cell into each spot on the array
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        cells[row][col] = new Cell();
      }
    }
    //add a bunch of mines which would be a 'type' of cell

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
        System.out.print(". ");
      }
      System.out.println();
    }
  }

  public void reveal(int row, int column) {}

  public boolean exploded() {
    return false;
  }
}
