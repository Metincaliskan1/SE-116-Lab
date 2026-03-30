public class Vehicle {
    protected String  licensePlate;
    private int dailyRate;

    public Vehicle(String licensePlate,int dailyRate){
        this.dailyRate=dailyRate;
        this.licensePlate=licensePlate;

    }
    public int getDailyRate(){
        return dailyRate;
    }
    public int calculateRental(int days){
        return days*dailyRate;
    }
    public void safetyCheck(){
        System.out.println("The parts of vehicle is checking...");
        System.out.println("Truck can be go");
    }
    public boolean checkRisk(){
        return false;
    }



}
