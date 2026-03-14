public class HeavyDutyTruck extends Truck{
    private int axleCount;
    public HeavyDutyTruck(String licensePlate,int dailyRate,int cargoCapacity,int axleCount){
        this.axleCount=axleCount;
        super(licensePlate,dailyRate,cargoCapacity);
    }

    @Override
    public int calculateRental(int days){
        return days*getDailyRate()*axleCount;
    }

    @Override
    public boolean checkRisk(){
        if (axleCount>4){
            return true;
        }return false;
    }

}
