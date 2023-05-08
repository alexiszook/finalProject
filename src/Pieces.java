public class Pieces {

    static int amount;
    String color;

    public Pieces() {
        // construct piece
    }

    public int getAmount(){
        return amount;
    }

    public String getColor(){
        return color;
    }

    public static void removePiece(){
        amount --;
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
     * check to see if the player is moving their piece to a valid index
     *
     * @return whether the player can move their piece in the place they chose
     */
    public boolean validMove(){
        //TODO: implement this
        return false;
    }


}
