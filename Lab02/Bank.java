public class Bank {
    static double transferFeeRate;
    public static double setTransferFeeRate(double rate){
        return transferFeeRate = rate;
    }
    public static double getTransferFeeRate(){
        return transferFeeRate;
    }
    public static double calculateTransferFee(double amount){
        return getTransferFeeRate()*amount;
    }

}
