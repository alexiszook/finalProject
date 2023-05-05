public class Board {

    /**
     * The number of rows and columns in the square checkers board
     */
    private static final int DIMEN = 8;


    /**
     * 2D array representing the state of the checkers board
     */
    private char[][] currentBoard = new char[DIMEN][DIMEN];

    /**
     * creates an initial checkers board with x's and o's as pieces
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


    public void remove(){
        //TODO: implement this method

        //will remove opponent's piece when it is jumped and update amount
    }

    public void jump() {
        //TODO: implement this method/decide if it's needed

        // will move the piece "two over" and "jump" over opponent's piece
        // the opponents piece will be deleted from the board
    }
}
