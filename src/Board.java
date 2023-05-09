public class Board {

    /**
     * The number of rows and columns in the square checkers board
     */
    private static final int DIMEN = 8;


    /**
     * 2D array representing the state of the checkers board
     */
    private static char[][] currentBoard = new char[DIMEN][DIMEN];

    /**
     * creates an initial checkers board with r's and b's as pieces
     */
    public Board() {
        // Checkerboard constructor
        // 8x8 board
        // will call player and set each piece in its initial place
        char[][] currentBoard = this.currentBoard;
        //initialize board
        for (int i=0;i<DIMEN;i++)
            for (int j=0;j<DIMEN;j++)
                currentBoard[i][j] = '_';

        for (int i=1;i<DIMEN;i+=2) {
            currentBoard[i][1] = 'r';
            currentBoard[i][5] = 'b';
            currentBoard[i][7] = 'b';
        }
        for (int i=0;i<DIMEN;i+=2) {
            currentBoard[i][0] = 'r';
            currentBoard[i][2] = 'r';
            currentBoard[i][6] = 'b';
        }

    }

    /**
     * moves a piece to a new position
     * @param curX current x coordinate of the piece
     * @param curY current y coordinate of the piece
     * @param newX new x coordinate of the piece
     * @param newY new y coordinate of the piece
     */
    public static void move(char turn, int curX, int curY, int newX, int newY) {
        // if there is a piece already in the desired position:
        // if it is their own piece: will be asked to try again
        // if the opponents piece can not be "jumped over": will be asked to try again
        // if the opponents piece can "jump over it": will call jump method
        //TODO: implement method and add exception if the move isn't valid

        // Change appropriate board elements and decrement redcheckers or
        // blackcheckers if necessary.

        if(Pieces.validMove(turn, curX, curY, newX, newY)){

        }
        //replace old space with _ and fill new space with piece
        currentBoard[curX][curY] = '_';
        currentBoard[newX][newY] = turn;

        //check to see if a piece is being jumped and update board and piece amounts accordingly
        if (Math.abs(curX-curY)==2) {
            if (turn == 'r' && (newY - curY == 2) &&
                    currentBoard[(curX+newX)/2][(curY + newY)/2] == 'b')
                Black.amount--;
            else if (turn == 'b' && (newX - curX == -2) &&
                    currentBoard[(curX+newX)/2][(curY+newY)/2] == 'r')
                Red.amount--;
        }
    }

    /**
     * creates a king piece when a piece reaches the other end, and it makes the piece capitalized to represent this
     *
     * @param color of the piece
     * @param x coordinate of piece
     * @param y coordinate of piece
     */

    //need to run this after each move to check and see if a king needs to be made
    public void king(String color, int x, int y) {
        if((currentBoard[x][y] == ('r')) && (y == 8)){
            King king = new King("red", x, y);
            currentBoard [x][y] = 'R';
        } else if((currentBoard[x][y] == ('b')) && (y == 1)){
            King king = new King("black", x, y);
            currentBoard[x][y] = 'B';
        }

    }

    public boolean isKing(int x, int y){
        if(currentBoard[x][y] == 'R' || currentBoard[x][y] == 'B'){
            return true;
        } else{
            return false;
        }

    }

    public static char getSpace(int x, int y){
        return currentBoard[x][y];
    }

    /**
     * updates and prints board after a player's turn
     *
     * @return current game board
     */
    public void printBoard(){
                System.out.println("  1 2 3 4 5 6 7 8 x");
        for (int i=0;i<DIMEN;i++) {
            System.out.print((i+1) + " ");
            for (int j=0;j<DIMEN;j++) {
                System.out.print(currentBoard[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("y");


    }

}
