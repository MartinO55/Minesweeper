package com.martin;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

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
    //so what we could do Is ask the user for their name, and if the name is Alex, set num mines to 99

    board = new Board();
    board.init(10);

    userInput = new Scanner(System.in);
    //primary game loop

    while (true) { //cause we may want to set this to false?
      board.draw();
      //get user input
      int row = getInput("input row: ");
      int column = getInput("input column: ");
      //so you could just add an action input here

      //handle user input
      board.reveal(row, column);
      //check for explosions

      if (board.exploded()) {
        System.out.println("You went out with a Bang!");

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
