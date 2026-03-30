public class DigitalBank {
    public static void main(String[] args){
        BankAccount user1 = new BankAccount("Metin",1234567890L);
        BankAccount user2 = new BankAccount("Mehmet",1267567890L);

        user1.deposit(20);

        user1.transferTo(user2,10);
        user1.displayAccountInfo();
        user1.displayHistory();
        user2.displayHistory();










    }
}
