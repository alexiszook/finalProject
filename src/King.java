public class King extends Pieces{

    //position
    int x;
    int y;
    public King(String color, int x, int y){
        //create a King piece
        //should be the same color as the piece it changed into a King
    }

    //Kings have different valid moves than regular pieces
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
                    Black.amount--;
                } else {
                    Red.amount--;
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
