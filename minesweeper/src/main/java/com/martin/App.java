package com.martin;

import java.util.Scanner;

//So... this needs to  start the came, call the board, and manage the user interaction, and decide when the game is finished
public class App {

  private Board board;
  private Scanner userInput;

  //private Boolean jumanji;//So we had this for a bool to set in the while loop, but I don't know where you would unset it or reset it

  public static void main(String[] args) {
    //game = new game
    App game = new App();
    game.start();
  }

  public void start() {
    //create a board

    userInput = new Scanner(System.in);

    System.out.print("Please enter your name...");
    String name = userInput.next();

    board = new Board();
    if (name.toLowerCase().equals("alex")) {
      board.init(99);
    } else board.init(10);

    //primary game loop
    while (true) {
      board.draw();
      //get user input, handle it
      int row = getInput("input row: ");
      //check for out of bounds input
      while (row > board.numRows) {
        row = getInput("That row is not assigned to you, comrade!: ");
      }
      int column = getInput("Input column: ");
      while (column > board.numCols) {
        column = getInput("That column is not assigned to you, comrade!: ");
      }

      //so you could just add an action input here, input action

      board.reveal(row, column);

      //check for explosions
      if (board.exploded(row, column) == true) {
        board.reveal(row, column);
        board.draw();
        System.out.println("You went out with a Bang!");

        break;
      }
      //check to end the game on a win
      if (board.checkForWin()) {
        board.reveal(row, column);
        board.draw();
        System.out.printf(
          "Congratulations %d!!! You are the Minesweeper!",
          name
        );
        break;
      }
    }

    userInput.close();
  }

  private int getInput(String message) {
    System.out.print(message);

    while (!userInput.hasNextInt()) {
      System.out.print("enter a number...");
      userInput.next();
    }

    int input = userInput.nextInt();

    return input;
  }
}
