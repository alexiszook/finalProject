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
        //TODO: implement this
        return false;
    }

}
