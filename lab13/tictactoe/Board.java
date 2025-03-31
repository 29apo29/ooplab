package tictactoe;

import java.lang.StringBuffer;

public class Board {
    char[][] board = { { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' } };
    private boolean currentPlayer = true;
    private int moveCount = 0;

    public boolean isEnded() {
        return this.moveCount == 9;
    }

    public boolean getCurrentPlayer() {
        return this.currentPlayer;
    }

    public int getCurrentPlayerInt() {
        return this.currentPlayer ? 1 : 2;
    }

    public void move(int row, int column) throws InvalidMoveException {
        if (row < 1 || row > 3)
            throw new InvalidMoveException("Row number should be between 1 and 3!");
        if (column < 1 || column > 3)
            throw new InvalidMoveException("Column number should be between 1 and 3!");
        if (this.board[row - 1][column - 1] != ' ')
            throw new InvalidMoveException("Location already occupied!");

        this.board[row - 1][column - 1] = this.currentPlayer ? 'X' : 'O';
        this.moveCount += 1;
        this.currentPlayer = !this.currentPlayer;
    }
    public boolean IsThereWinner(int row, int column) {
        row -= 1;
        column -= 1;
        char symbol = this.board[row][column];
        boolean win = true;

        for (int k = 0; k < 3; k++) {
            if (this.board[row][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (this.board[column][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (this.board[2 - k][k] != symbol) {
                win = false;
            }
        }
        if (win) {
            return win;
        }
        win = true;
        for (int k = 0; k < 3; k++) {
            if (this.board[k][k] != symbol) {
                win = false;
            }
        }
        return win;
    }
    public String winnerMessage(){
        return "Player "+ (!this.currentPlayer?"X":"O") + " won the game.";
    }
    
    @Override
    public String toString() {

        StringBuffer strbuffer = new StringBuffer();
        strbuffer.append(" 1   2   3\n");
        strbuffer.append("--------------\n");
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board[row].length; column++) {
                strbuffer.append("|");
                strbuffer.append(" " + this.board[row][column] + " ");
                if (column == 2)
                    strbuffer.append("|");
            }
            strbuffer.append("\n");
            strbuffer.append("--------------\n");
        }
        return strbuffer.toString();
    }

}
