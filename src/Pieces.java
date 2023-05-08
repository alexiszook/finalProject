public class Pieces {

    int amount;
    String color;

    public Pieces(String color) {
        // construct piece, initially not a king
        //assign piece either red or black

        amount = 12;
    }

    public int getAmount(){
        return amount;
    }

    public String getColor(){
        return color;
    }

    /**
     * checks to see if the player has won by seeing if the given losing color has lost
     * @return true if the player has won
     */

    public boolean hasWon(Pieces loser) {
        if(loser.hasLost()){
            return true;
        }else{
            return false;
        }

    }

    /**
     * checks if that color has 0 pieces left and therefore has lost
     * @return true if the color has 0 pieces left
     */
    public boolean hasLost() {
        //sees who the supposed winner is
        if(color.equals("red")) {
            if (amount == 0) {
                return true;
            } else {
                return false;
            }
        }
        else if(color.equals("black")){
            if(amount == 0){
                return true;
            }else{
                return false;
            }
        } else{
            return false;
        }
    }






    /**
     * moves a piece to a new position
     * @param curX current x coordinate of the piece
     * @param curY current y coordinate of the piece
     * @param newX new x coordinate of the piece
     * @param newY new y coordinate of the piece
     */
    public void move(int curX, int curY, int newX, int newY) {
        // if there is a piece already in the desired position:
        // if it is their own piece: will be asked to try again
        // if the opponents piece can not be "jumped over": will be asked to try again
        // if the opponents piece can "jump over it": will call jump method
        //TODO: implement method and add exception if the move isn't valid
    }
}
