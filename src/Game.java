import java.util.Scanner;

public class Game {
    private Board gameBoard;
    private char whoseTurn;
    private String colorTurn = "black";
    private Pieces red = new Red();
    private Pieces black = new Black();
    public Game() {
        // will call Board class and use those methods
        // will construct the "AI" computer opponent
        this.gameBoard = new Board();
        whoseTurn = 'b';
    }


    public void gameLoop() throws Exception {
        gameBoard.printBoard();
        Scanner scnr = new Scanner(System.in);

        while(!black.hasLost() && !red.hasLost()) {
            //TODO: finish the actual playing of the game
            try{
                System.out.println("it is " +colorTurn + "'s turn");
                System.out.println("red has " + Red.getAmount() + " checkers");
                System.out.println("black has " + Black.getAmount() + " checkers");
                System.out.println("Enter the space(x,y) of the piece you want to move");
                System.out.println("(ex. x=1, y=2 would be entered as 1 2)");
                System.out.println("Enter the space you want the piece to move to in the same format");
                gameBoard.move(whoseTurn, scnr.nextInt(), scnr.nextInt(), scnr.nextInt(), scnr.nextInt());
                gameBoard.printBoard();

                //switch turns
                if(whoseTurn == 'b'){
                    whoseTurn = 'r';
                    colorTurn = "red";
                }else{
                    whoseTurn = 'b';
                    colorTurn = "black";
                }
            }
            catch (Exception e){
                System.out.println("Can't play there, try again");
            }

        }
        if(black.hasLost()){
            System.out.println("Red is the winner!");
        }
        }

}



