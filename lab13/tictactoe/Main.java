package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Board board = new Board();
        System.out.println(board);

        while(!board.isEnded()){
            int player = board.getCurrentPlayerInt();
            int row = 0, column = 0;
            boolean invalidRow = false;
            boolean invalidColumn = false;
            do{
                System.out.println("Player " + player + " enter a row number:");
                try{
                    row = Integer.valueOf(reader.nextLine());
                    invalidRow = false;
                }catch(NumberFormatException nfe){
                    System.out.println("Invalid integer");
                    invalidRow = true;
                }
            }while(invalidRow);
            do{
                System.out.println("Player " + player + " enter a column number:");
                try{
                    column = Integer.valueOf(reader.nextLine());
                    invalidColumn = false;
                }catch(NumberFormatException nfe){
                    System.out.println("Invalid integer");
                    invalidColumn = true;
                }
            }while(invalidColumn);
            try{
                board.move(row, column);
            }catch(InvalidMoveException ime){
                System.out.println(ime.getMessage());
                // continue;
            }
            System.out.println(board);
            if(board.IsThereWinner(row, column)){
                System.out.println(board.winnerMessage());
                break;
            }
        }
        reader.close();
    }
}
