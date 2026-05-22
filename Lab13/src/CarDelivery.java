public class CarDelivery extends Delivery{
    public CarDelivery(String orderId,double distanceKm,double baseFee){
        super(orderId, distanceKm, baseFee);
    }
    @Override
    public double calculateTotal(){
        double total= getBaseFee()+(getDistanceKm()*3.5)+15;
        return total;
    }
}
