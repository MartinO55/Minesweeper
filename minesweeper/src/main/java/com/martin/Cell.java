package com.martin;

public class Cell {

  private boolean isMine;
  private boolean isRevealed;
  private int adjacentMines;

  public boolean isMine() {
    return isMine;
  }

  public void setMine(boolean mine) {
    isMine = mine;
  }

  public boolean isRevealed() {
    return false;
  }

  public char displayValue() {
    if (isRevealed) { //should be !isRevealed to hide stuff, inverted for testing
      return ('-');
    } else if (isMine) {
      return 'X';
    } else if (adjacentMines == 0) {
      return ' ';
    } else {
      return (char) ('0' + adjacentMines);
    }
  }

  public void setAdjacentMines(int count) {
    this.adjacentMines = count;
  }
}
