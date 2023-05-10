public class Red extends Pieces{

    static int amount;
    public Red(){
        color = "red";
        amount = 12;
    }
    public static int updateAmount(){
        return amount--;
    }
    public static int getAmount() {
        return amount;
    }
}
