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
    public static void move(char turn, int curX, int curY, int newX, int newY) throws Exception {
        if(Board.isKing(curX, curY)){
            char kingColor;
            if(King.validMove(turn, curX, curY, newX, newY)){
                if(turn == 'r'){
                    kingColor = 'R';
                }else{
                    kingColor = 'B';
                }
                currentBoard[curX][curY] = '_';
                currentBoard[newX][newY] = kingColor;
            }
        }
        else if(Pieces.validMove(turn, curX, curY, newX, newY)) {
            //replace old space with _ and fill new space with piece
            currentBoard[curX][curY] = '_';
            currentBoard[newX][newY] = turn;
            //check if a king needs to be made
            Board.king(newX,newY);
        } else{
            throw new Exception();
        }
    }

    /**
     * creates a king piece when a piece reaches the other end, and it makes the piece capitalized to represent this
     *
     * @param x coordinate of piece
     * @param y coordinate of piece
     */
    public static void king(int x, int y) {
        if((currentBoard[x][y] == ('r')) && (y == 7)){
            currentBoard [x][y] = 'R';
        } else if((currentBoard[x][y] == ('b')) && (y == 0)){
            currentBoard[x][y] = 'B';
        }

    }

    /**
     * Checks if a checker is a king
     * @param x coordinate of the checker being checked
     * @param y coordinate of the checker being checked
     * @return whether the checker is a king
     */
    public static boolean isKing(int x, int y){
        if(currentBoard[x][y] == 'R' || currentBoard[x][y] == 'B'){
            return true;
        } else{
            return false;
        }

    }

    /**
     * Gives the character that is in a certain space on the board
     *
     * @param x coordinate of the desired space
     * @param y coordinate of the desired space
     * @return the character that is in the desired space on the board
     */
    public static char getSpace(int x, int y){
        return currentBoard[x][y];
    }

    /**
     * sets a certain space on the board to a new character
     *
     * @param c character that is being set in the desired space
     * @param x coordinate of the desired space
     * @param y coordinate of the desired space
     */
    public static void setSpace(char c, int x, int y){
        currentBoard[x][y] = c;
    }

    /**
     * updates and prints board after a player's turn
     */
    public void printBoard(){
                System.out.println("  0 1 2 3 4 5 6 7 x");
        for (int i=0;i<DIMEN;i++) {
            System.out.print((i) + " ");
            for (int j=0;j<DIMEN;j++) {
                System.out.print(currentBoard[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("y");


    }

}
