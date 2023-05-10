public class Black extends Pieces {

    static int amount;
    public Black() {
        color = "black";
        amount = 12;
    }

    public static int updateAmount(){
        return amount--;
    }

    public static int getAmount() {
        return amount;
    }
}

