public class King extends Pieces{

    //position
    int x;
    int y;
    public King(String color, int x, int y){
        //create a King piece
        //should be the same color as the piece it changed into a King
    }

    //Kings have different valid moves than regular pieces
    @Override
    public boolean validMove(int curX, int curY, int newX, int newY){
       Board board = new Board();
        int xJump = newX+1;
        int yJump = newY+1;
        //TODO: implement this
        if (newX < curX) {
            xJump = newX - 1;
        }
        if (newY < curY) {
            yJump = newY - 1;
        }

        if (board.getSpace(newX,newY) == 'r' || board.getSpace(newX,newY) == 'b') {
            return false;
        } else if (board.getSpace(xJump,yJump) == 'r' || board.getSpace(xJump,yJump) == 'b') {
            return false;
        } else {
            return true;
        }
    }

}
