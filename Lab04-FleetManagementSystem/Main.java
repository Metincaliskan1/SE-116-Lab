import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Vehicle("35 AJB 2345", 10);
        vehicles[1] = new Truck("35 DB 6577",30 , 20);
        vehicles[2] = new HeavyDutyTruck("35 GB 9965", 45,5 , 30);


        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];
            System.out.println(v.licensePlate);
            v.safetyCheck();

        }


    }
}
