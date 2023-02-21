package com.martin;

public class Cell {

  private boolean isMine;
  private boolean isRevealed;

  public boolean isMine() {
    return isMine;
  }

  public void setMine(boolean mine) {
    isMine = mine;
  }

  public boolean isRevealed() {
    return false;
  }

  public String displayValue() {
    return null;
  }
}
