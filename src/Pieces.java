public class Pieces {
    static String color;

    public Pieces() {
        // construct piece
    }




    public static String getColor() {
        return color;
    }


    /**
     * checks if that color has 0 pieces left and therefore has lost
     *
     * @return true if the color has 0 pieces left
     */
    public boolean hasLost() {
        //sees who the supposed winner is
        if (color.equals("red")) {
            if (Red.getAmount() == 0) {
                return true;
            } else {
                return false;
            }
        } else if (color.equals("black")) {
            if (Black.getAmount() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * check to see if the player is moving their piece to a valid index
     *
     * @return whether the player can move their piece in the place they chose
     */
    public static boolean validMove(char turn, int curX, int curY, int newX, int newY) {
         // Checks case of regular move
        if (Math.abs(curX - newX) == 1 && Board.getSpace(newX,newY) == '_') {
            if ((turn == 'r') && (newY - curY == 1) && Board.getSpace(curX,curY) == 'r') {
                return true;
            } else if ((turn == 'b') && (newY - curY == -1) && Board.getSpace(curX,curY) == 'b') {
                return true;
            }
            else{
                return false;
            }
        }
        // Checks case of a jump
        else if (Math.abs(curX - newX) == 2) {
            if (turn == 'r' && (newY - curY == 2) && ((Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == 'b')
                    || Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == 'B')) {
                Board.setSpace('_',(curX + newX) / 2, (curY + newY) / 2);
                Black.updateAmount();
                return true;
            } else if (turn == 'b' && (newY - curY == -2) && ((Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == 'r')
                    || Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == 'R')) {
                Board.setSpace('_',(curX + newX) / 2, (curY + newY) / 2);
                Red.updateAmount();
                return true;
            }
            else{
                return false;
            }
        }
        else {
                return false;
        }
    }

}