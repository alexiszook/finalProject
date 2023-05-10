public class King {

    /**
     * Checks valid moves for Kings
     * @param turn who's turn it is
     * @param curX current x coordinate of checker
     * @param curY current y coordinate of checker
     * @param newX new x coordinate of checker
     * @param newY new y coordinate of checker
     * @return whether the move is valid
     */
    public static boolean validMove(char turn, int curX, int curY, int newX, int newY){

        char kingColor;
        char oppColor;
        char oppKing;

        if(turn == 'r'){
            kingColor = 'R';
            oppColor = 'b';
            oppKing = 'B';
        }else{
            kingColor = 'B';
            oppColor = 'r';
            oppKing = 'R';
        }
        if (Math.abs(curX - newX) == 1 && Board.getSpace(newX,newY) == '_') {
            if ((Math.abs(newY - curY) == 1) && Board.getSpace(curX,curY) == kingColor) {
                return true;
            }
            else{
                return false;
            }
        }
        // Checks case of a jump
        else if (Math.abs(curX - newX) == 2) {
            if ((Math.abs(newY - curY) == 2) && ((Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == oppColor)
                    || Board.getSpace((curX + newX) / 2, (curY + newY) / 2) == oppKing)) {

                Board.setSpace('_',(curX + newX) / 2, (curY + newY) / 2);
                if(oppColor == 'b') {
                    Black.updateAmount();
                } else {
                    Red.updateAmount();
                }

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
