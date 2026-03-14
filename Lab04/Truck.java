public class Truck extends Vehicle{
    private int cargoCapacity;

    public Truck(String licensePlate,int dailyRate, int cargoCapacity){
        this.cargoCapacity=cargoCapacity;
        super(licensePlate,dailyRate);
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void safetyCheck(){
        if (getCargoCapacity()<40||getCargoCapacity()<0){
            System.out.println("Truck can be go.");
        }
    }
    @Override
    public boolean checkRisk(){
        if (cargoCapacity>20){
            return true;
        }return false;
    }


}
