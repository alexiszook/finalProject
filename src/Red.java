public class Red extends Pieces{

    private static int amount;
    public Red(){
        color = "red";
        amount = 12;
    }

    /**
     * update the amount of Red checkers by -1
     */
    public static void updateAmount(){
        amount--;
    }

    /**
     * amount of red checkers left
     * @return the amount of red checkers
     */
    public static int getAmount() {
        return amount;
    }

}
