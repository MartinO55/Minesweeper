package com.martin;

public class Cell {

  public boolean isMine;
  private boolean isRevealed;
  private int adjacentMines;
  public int cellCount;

  public Cell(boolean isMine) {
    this.isMine = isMine;
    this.isRevealed = false;
    this.adjacentMines = 0;
  }

  public boolean isMine() {
    return isMine;
  }

  public void setMine(boolean mine) {
    isMine = mine;
  }

  public boolean isRevealed() {
    return isRevealed;
  }

  public void setRevealed(boolean revealed) {
    this.isRevealed = revealed;
  }

  public void setAdjacentMines(int count) {
    this.adjacentMines = count;
  }

  public int getAdjacentMines() {
    return adjacentMines;
  }

  public char displayValue() {
    if (!isRevealed) { //should be !isRevealed to hide stuff, invert for testing
      return ('-');
    } else if (isMine) {
      return 'X';
    } else if (adjacentMines == 0) {
      return ' ';
    } else {
      return (char) ('0' + adjacentMines);
    }
  }
}
