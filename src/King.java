public class King extends Pieces{

    //position
    int x;
    int y;
    public King(String color, int x, int y){
        super(color);
        //create a King piece
        //should be the same color as the piece it changed into a King
    }

    public void move(int curX, int curY, int newX, int newY) {
        //TODO: implement this method with different exceptions than the Pieces move method

        // if the piece is "kinged" it's allowed to go backwards and forwards

    }
}
