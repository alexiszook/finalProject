import java.util.Scanner;

public class Game {
    private Board gameBoard;
    private char whoseTurn;
    private String colorTurn = "black";
    private Pieces red = new Red();
    private Pieces black = new Black();
    public Game() {
        this.gameBoard = new Board();
        whoseTurn = 'b';
    }

    /**
     * prints out the board and asks the player to take their turn and updates the board accordingly
     * loops until there is a winner
     *
     */
    public void gameLoop() {
        gameBoard.printBoard();
        Scanner scnr = new Scanner(System.in);

        while(!black.hasLost() && !red.hasLost()) {
            try{
                System.out.println("it is " +colorTurn + "'s turn");
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



