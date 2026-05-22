import javax.naming.Name;

public class Main {
    public static void main(String[] args) {


        Delivery[] Deliveries=new Delivery[3];
        Deliveries[0]=new BikeDelivery("1312312",45,15);
        Deliveries[1]=new CarDelivery("568567567",25,30);
        Deliveries[2]=new BikeDelivery("867686",12,10);


        //for (int i=0;i<Deliveries.length;i++){
        //            Deliveries[i].printReceipt();
        //            System.out.println("-----------");
        //        }
        String[] customerNames = {"Ahmet", "Mehmet", "Selin"};

        RecordBox<Delivery> Records=new RecordBox<>(Deliveries);
        RecordBox<String>Name=new RecordBox<>(customerNames);
        Records.getRecord(1).printReceipt();
        System.out.println("-----------");
        Name.printAll();
        System.out.println("----------");
        Records.printAll();
    }
}
