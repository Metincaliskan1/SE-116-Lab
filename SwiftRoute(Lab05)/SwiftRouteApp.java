import java.util.HashMap;
import java.util.Scanner;

public class SwiftRouteApp {
    public static void main(String[] args) {
         String trackingNo;
         String contentType;
         int weightKg;
         int distanceKm;
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Shipment>Ships=new HashMap(5);

        System.out.print("How many ship do you add? :");
        int size= scanner.nextInt();


        for (int i=0;i<size;i++){
            System.out.println("===Shipment Entry Menu===\n" +
                    "1.Standart\n" +
                    "2.Express\n" +
                    "3.International\n");
            int choice= scanner.nextInt();

            i=i+1;
            System.out.println("Ship :"+i);
            i=i-1;
            switch (choice){
                case 1:
                    System.out.print("Enter tracking no: ");
                    trackingNo=scanner.next();

                    System.out.print("Enter content type:");
                    contentType= scanner.next();

                    System.out.print("Enter weight:");
                    weightKg= scanner.nextInt();

                    System.out.print("Enter distance:");
                    distanceKm= scanner.nextInt();

                    Shipment ship1 = new StandardShipping(trackingNo,contentType,weightKg,distanceKm);

                    Ships.put(trackingNo,ship1);
                    System.out.println("------------------------");
                    break;

                case 2:
                    System.out.print("Enter tracking no: ");
                    trackingNo=scanner.next();

                    System.out.print("Enter content type:");
                    contentType= scanner.next();

                    System.out.print("Enter weight:");
                    weightKg= scanner.nextInt();

                    System.out.print("Enter distance:");
                    distanceKm= scanner.nextInt();

                    Shipment ship2 = new ExpressShipping(trackingNo,contentType,weightKg,distanceKm);

                    Ships.put(trackingNo,ship2);
                    System.out.println("------------------------");
                    break;

                case 3:
                    System.out.print("Enter tracking no: ");
                    trackingNo=scanner.next();

                    System.out.print("Enter content type:");
                    contentType= scanner.next();

                    System.out.print("Enter weight:");
                    weightKg= scanner.nextInt();

                    System.out.print("Enter distance:");
                    distanceKm= scanner.nextInt();

                    Shipment ship3 = new InternationalShipping(trackingNo,contentType,weightKg,distanceKm);
                    Ships.put(trackingNo,ship3);
                    System.out.println("------------------------");
                    break;
                default:
                    System.out.println("Enter valid choice...");
                    System.out.println("------------------------");
            }
        }



        for (Shipment ship:Ships.values()){

            if (ship instanceof ExpressShipping){
                Shipment s=(ExpressShipping)ship;
                ((ExpressShipping) ship).printExpressNote();
                ship.printReceipt();
            }
            else{ship.printReceipt();
            }
        }
    }

}
