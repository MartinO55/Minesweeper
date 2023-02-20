# Project: Minesweeper

## MVP

- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid

  - Grid will be represented by a 2 dimensional array (or array like structure)

- The user will be able to enter a command that represents a coordinate to check a location for a mine

  - (e.g "00" or "19" or "X: 0, Y: 9")

- After every guess the application should "redraw" the 2d grid. Releaving either a number from 0-8 depending on how many mines surround that location (based on the cooridnate)
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- Game over screen and exit the application

- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command

## Bonuses (optional)

- Allow for the user to configure number of mines and grid size via a configuration.json file OR command line arguments
- Keep track of win/loss in a file
  (Difficult) Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares

### Guidance

- Think about how this can be achieved in an OOP way
- A focus on single responsibility, and also maintainability/extension
- If you're lost, ask for help early
- Avoid guides, you'll just end up copying it
- If you don't understand minesweeper. Ask a coach.

### What you don't need to do

- Flag mines
- Have a fancy display. A grid with "?" "1" etc is fine

### Outline

Set up the game board: You can create a 2D array to represent the game board, where each element of the array represents a tile on the board.

Place mines: You can randomly select elements of the 2D array to represent mines, and store the locations of the mines in another data structure.

Calculate numbers for each tile: For each tile that isn't a mine, calculate the number of mines in its surrounding 8 tiles, and store that number in the corresponding element of the 2D array.

Display the game board: You can use a graphical user interface (GUI) library such as JavaFX or Swing to display the game board to the user. Tiles that have not been clicked on yet can be displayed as covered, and tiles that have been clicked on can be displayed with either a number or a mine icon, depending on the contents of that tile.

Handle user clicks: You can use the GUI library's event-handling mechanism to detect when the user clicks on a tile, and then reveal the contents of that tile. If the tile is a mine, the game ends. If the tile is a number, you can display that number. If the tile is blank, you can reveal all of the surrounding tiles.

Implement game logic: You can use the 2D array and the data structure storing the locations of the mines to implement the game logic, such as checking for win conditions (when all mines have been found) and handling the display of the numbers and mines on the game board.
