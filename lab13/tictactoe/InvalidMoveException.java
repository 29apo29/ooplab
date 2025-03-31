package tictactoe;

public class InvalidMoveException extends Exception {

    // public InvalidMoveException() {
    //     super("This move is invalid");
    // }
    public InvalidMoveException(String message) {
        super(message);
    }

}
