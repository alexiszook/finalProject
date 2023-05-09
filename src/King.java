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
    public boolean validMove(){
       Board board = new Board();
        int xJump = x+1;
        int yJump = y+1;
        //TODO: implement this
        if (x < curX) {
            xJump = x - 1;
        }
        if (y < curY) {
            yJump = y - 1;
        }

        if (board.getSpace(x,y) == 'r' || board.getSpace(x,y) == 'b') {
            return false;
        } else if (board.getSpace(xJump,yJump) == 'r' || board.getSpace(xJump,yJump) == 'b') {
            return false;
        } else {
            return true;
        }
    }

}
