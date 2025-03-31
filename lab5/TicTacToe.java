import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

        boolean who = true;
        boolean gameEnded = false;
        int validCounter = 0;
        Scanner sc = new Scanner(System.in);

        printBoard(board);
        while (!gameEnded) {
            String whoPlay = who ? "X" : "O";
            System.out.println(whoPlay + " is playing.");
            System.out.println("Row: ");
            int signedRow = sc.nextInt();
            System.out.println("Column: ");
            int signedColumn = sc.nextInt();
            if (isPlaceValid(signedRow, signedColumn, board)) {
                board[signedRow - 1][signedColumn - 1] = who ? 'X' : 'O';
            } else {
                System.out.println("The place is not suit. Please write suit place");
                printBoard(board);
                continue;
            }
            if (IsThereWinner(board, signedRow, signedColumn)) {
                String whoS = who ? "Player 1 (X)" : "Player 2(O)";
                System.out.println(whoS + " won the game.");
                gameEnded = !gameEnded;
                validCounter += 1;
                break;
            }
            if (validCounter == 9) {
                System.out.println("Game is finished 'DRAW' ");
                gameEnded = !gameEnded;
            }
            validCounter += 1;
            System.out.println("Valid act number: " + validCounter);
            who = !who;
            printBoard(board);
        }
        printBoard(board);
        System.out.println("Valid act number: " + validCounter);

    }

    public static boolean isGameFinish(char[][] board) {
        for (char[] line : board) {
            for (char charac : line) {
                if (charac == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPlaceValid(int row, int column, char[][] board) {
        if (row > 3 || row < 1 || column > 3 || column < 1) {
            return false;
        }
        if (board[row - 1][column - 1] == ' ') {
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            String rowS = "";
            for (int column = 0; column < 3; column++) {
                rowS = rowS + "[" + board[row][column] + "]";
            }
            System.out.println(rowS);
            rowS += "\n";
        }
    }

    public static boolean IsThereWinner(char[][] board, int row, int column) {
        row -= 1;
        column -= 1;
        char symbol = board[row][column];
        boolean win = true;

        for (int k = 0; k < 3; k++) {
            if (board[row][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (board[column][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (board[2 - k][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (board[k][k] != symbol) {
                win = false;
            }
        }
        return win;
    }
}