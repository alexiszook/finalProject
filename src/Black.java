public class Black extends Pieces {

    public static int amount;

    public Black() {
        color = "black";
        amount = 12;
    }

    /**
     * update the amount of black checkers by -1
     */
    public static void updateAmount(){
        amount--;
    }

    /**
     * amount of black checkers left
     * @return the amount of black checkers left
     */
    public static int getAmount() {
        return amount;
    }


}

