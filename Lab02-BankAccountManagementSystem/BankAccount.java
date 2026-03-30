public class BankAccount {
    private String ownerName;
    private long iban;
    private double balance;
    private String[] transactionHistory;

    public BankAccount(String ownerName,long iban){
        this.ownerName=ownerName;
        this.iban=iban;
        this.balance=0;
        this.transactionHistory=new String[10];
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }
    public long getIban(){
        return iban;
    }
    public void setIban(long iban){
        this.iban=iban;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance=balance;
    }

    private void addTransaction(String record){
        for (int i=0;i<10;i++){
            if (transactionHistory[i]==null){
                transactionHistory[i]=record;
                return;
            }
        }
            for (int j = 0; j <9; j++){
                transactionHistory[j]=transactionHistory[j+1];

            }
            transactionHistory[9]=record;
    }

    public void deposit(int amount){
        this.balance=balance+amount;
        addTransaction("DEPOSIT: "+amount);
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance=balance-amount;
            addTransaction("WITHDRAW: "+amount);
        }else {
            addTransaction("FAILED_WITHDRAW: " + amount);
        }
    }
    public void transferTo(BankAccount receiver,int amount){
        double fee = amount*Bank.getTransferFeeRate();
        if (this.balance>=amount+fee){
            withdraw(amount+fee);
            receiver.deposit(amount);
        }
        else {
            addTransaction("FAILED TRANSFER "+amount);
            System.out.println("Error");
        }
    }
    public void displayAccountInfo(){
        System.out.println("Name: "+getOwnerName());
        System.out.println("Iban: "+getIban());
        System.out.println("Balance: "+getBalance());
    }
    public void displayHistory(){
        for (int i=0;i<transactionHistory.length;i++){
            if (transactionHistory[i]==null){
                break;
            }
            System.out.println(i+1+"-"+transactionHistory[i]);

        }
    }





}
