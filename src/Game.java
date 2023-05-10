import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Board gameBoard;

    Queue<String> players;

    private char whoseTurn;
    private Pieces red = new Red();
    private Pieces black = new Black();
    public Game() {
        this.gameBoard = new Board();
        players = new LinkedList<>();
        whoseTurn = 'b';
    }

    /**
     * prints out the board and asks the player to take their turn and updates the board accordingly
     * loops until there is a winner
     *
     */
    public void gameLoop() {
        gameBoard.printBoard();
        //add players to queue
        players.add("black");
        players.add("red");

        Scanner scnr = new Scanner(System.in);

        while(!black.hasLost() && !red.hasLost()) {
            try{
                String player = players.element();
                System.out.println("it is " + player + "'s turn");
                System.out.println("Enter the space(x,y) of the piece you want to move");
                System.out.println("(ex. x=1, y=2 would be entered as 1 2)");
                System.out.println("Enter the space you want the piece to move to in the same format");
                Board.move(whoseTurn, scnr.nextInt(), scnr.nextInt(), scnr.nextInt(), scnr.nextInt());
                gameBoard.printBoard();

                //switch turns
                if(player.equals("black")){
                    whoseTurn = 'r';
                }else{
                    whoseTurn = 'b';
                }
                players.remove();
                players.add(player);

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



