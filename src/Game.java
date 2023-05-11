import java.util.*;

public class Game {
    private Board gameBoard;

    /**
     * LinkedList that keeps track of the next player up
     */
    private Queue<String> players;

    /**
     * ArrayList that keeps track of all the moves throughout the game
     */
    private List<Integer> moves;

    private char whoseTurn;
    private Pieces red = new Red();
    private Pieces black = new Black();
    public Game() {
        this.gameBoard = new Board();
        players = new LinkedList<>();
        whoseTurn = 'b';
        moves = new ArrayList<>();
    }


    /**
     * stores the player's move to the moves arraylist
     *
     * @param curx x coordinate of the checker being moved
     * @param cury y coordinate of the checker being moved
     * @param newx x coordinate where the checker is moving to
     * @param newy y coordinate where the checker is moving to
     */
    public void moveHistory(int curx, int cury, int newx, int newy){
        int move;
        //combine all the coordinates into one number by multiplying them by their placeholder
        move = 1000*curx + 100*cury + 10*newx + newy;
        moves.add(move);
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
                int curx = scnr.nextInt();
                int cury = scnr.nextInt();
                int newx = scnr.nextInt();
                int newy = scnr.nextInt();
                Board.move(whoseTurn, curx, cury, newx, newy);
                moveHistory(curx, cury, newx, newy);

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
        }else{
            System.out.println("Black is the winner!");
        }

        System.out.println("would you like to access the log of moves from the game? (Y or N)");
        if(scnr.next().equals("Y")) {
            for (int move : moves) {
                System.out.println(move);
            }
        }

    }

}



