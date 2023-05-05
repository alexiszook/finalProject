import java.util.Scanner;

public class Game {
    public Game() {
        // will call Board class and use those methods
        // will construct the "AI" computer opponent
    }


    public static void main(String[] args){
        char whoseTurn = 'b';
        Board board = new Board();
        Pieces red = new Pieces("red");
        Pieces black = new Pieces("black");
        board.printBoard();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Black goes first.");
        System.out.println("Enter the space(x,y) of the piece you want to move");
        System.out.println("(ex. x=1, y=2 would be entered as 1 2)");
        System.out.println("Enter the space you want the piece to move to in the same format");
        black.move(scnr.nextInt(), scnr.nextInt(), scnr.nextInt(), scnr.nextInt());

        while(!black.hasLost() && !red.hasLost()) {
            //TODO: finish the actual playing of the game

            //switch turns
            if(whoseTurn == 'b'){
                whoseTurn = 'r';
            }else{
                whoseTurn = 'b';
            }
        }
        }
    }

