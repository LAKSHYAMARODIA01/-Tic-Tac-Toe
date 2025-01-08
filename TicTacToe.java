import java.io.*;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private static final String FILE_NAME = "game_state.txt";

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // Player 1 starts
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void saveGameState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < 3; i++) {
                writer.write(board[i][0] + "," + board[i][1] + "," + board[i][2]);
                writer.newLine();
            }
            writer.write("Player Turn: " + (currentPlayer == 'X' ? 1 : 2));
            System.out.println("Game state saved!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the game state.");
        }
    }

    public void loadGameState() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            for (int i = 0; i < 3; i++) {
                String line = reader.readLine();
                String[] values = line.split(",");
                for (int j = 0; j < 3; j++) {
                    board[i][j] = values[j].charAt(0);
                }
            }
            String turnLine = reader.readLine();
            currentPlayer = (turnLine.charAt(turnLine.length() - 1) == '1') ? 'X' : 'O';
            System.out.println("Game state loaded!");
        } catch (IOException e) {
            System.out.println("No saved game state found. Starting a new game.");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        game.loadGameState();
        
        while (true) {
            game.printBoard();
            System.out.println("Player " + (game.currentPlayer == 'X' ? "1" : "2") + ", enter your move (1-9) or 0 to save: ");
            int move = scanner.nextInt();

            if (move == 0) {
                game.saveGameState();
                continue;
            }

            int row = (move - 1) / 3;
            int col = (move - 1) % 3;

            if (move < 1 || move > 9 || game.board[row][col] != '-') {
                System.out.println("This move is not valid");
 continue;
            }

            game.board[row][col] = game.currentPlayer;

            if (game.checkForWin()) {
                game.printBoard();
                System.out.println("Player " + (game.currentPlayer == 'X' ? "1" : "2") + " wins!");
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("The game is a draw!");
                break;
            }

            game.changePlayer();
        }

        scanner.close();
    }
}