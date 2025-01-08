# Author : Lakshya Marodia (09_Jan_2025)
# Tic Tac Toe

## Project Description
Tic Tac Toe is a simple console-based game for two players, where players take turns to place their marks (X or O) on a 3x3 grid. The game includes features for saving and loading the game state, allowing players to resume their game at any time. This project is implemented in Java and provides an interactive console interface for a smooth gaming experience.

## Features Implemented
- **Two-Player Gameplay**: Players alternate turns to place their marks on the board.
- **Interactive Console Interface**: The game prompts players for their moves and displays the current board state.
- **Save and Load Game State**: Players can save their current game state to a file and load it later to continue playing.
- **Move Validation**: The game checks for valid moves to ensure players cannot overwrite existing marks or make moves outside the board.
- **Win and Draw Detection**: The game detects when a player has won or if the game has ended in a draw.

## How to Run the Project
1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed on your machine. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager for your operating system.
   
2. **Clone the Repository**: Use the following command to clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/tic-tac-toe.git
   ```

3. **Navigate to the Project Directory**:
   ```bash
   cd tic-tac-toe
   ```

4. **Compile the Java File**:
   ```bash
   javac TicTacToe.java
   ```

5. **Run the Compiled Java Program**:
   ```bash
   java TicTacToe
   ```

## Instructions for Installation
- **No additional libraries are required**: The project uses standard Java libraries for file handling and console input/output.
- **Ensure Java is installed**: Make sure you have the JDK installed to compile and run the program.

## Usage Instructions
- **Starting a New Game**: When you run the program, it will initialize a new game.
- **Making a Move**: Players are prompted to enter their move as a number from 1 to 9, corresponding to the positions on the board:
  ```
   1 | 2 | 3
  ---+---+---
   4 | 5 | 6
  ---+---+---
   7 | 8 | 9
  ```
- **Saving the Game**: To save the current game state, enter `0` when prompted for a move. The game state will be saved to `game_state.txt`.
- **Loading a Game**: If a saved game state exists, it will be loaded automatically when the program starts.

## Example Game Flow
```
Welcome to Tic Tac Toe!
Player 1: X
Player 2: O

Current Board:
- - -
- - -
- - -

Player 1, enter your move (1-9): 5
Current Board:
- - -
- X -
- - -

Player 2, enter your move (1-9): 3
Current Board:
- - O
- X -
- - -

Player 1, enter your move (1-9): 0
Game state saved!
```

## Contributing
Contributions are welcome! If you have suggestions for improvements or new features, feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Acknowledgments
- Thanks to the open-source community for providing resources and inspiration for this project.
