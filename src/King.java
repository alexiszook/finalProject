public class King extends Pieces{

    //position
    int x;
    int y;
    public King(String color, int x, int y){
        //create a King piece
        //should be the same color as the piece it changed into a King
    }

    //Kings have different valid moves than regular pieces
    public static boolean validMove(int curX, int curY, int newX, int newY){
        int xJump = newX+1;
        int yJump = newY+1;
        //TODO: implement this
        if (newX < curX) {
            xJump = newX - 1;
        }
        if (newY < curY) {
            yJump = newY - 1;
        }

        if (Board.getSpace(newX,newY) == 'r' || Board.getSpace(newX,newY) == 'b') {
            return false;
        } else if (Board.getSpace(xJump,yJump) == 'r' || Board.getSpace(xJump,yJump) == 'b') {
            return false;
        } else {
            return true;
        }
    }

}
