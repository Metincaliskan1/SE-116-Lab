public class BikeDelivery extends Delivery{
    public BikeDelivery(String orderId,double distanceKm,double baseFee){
        super(orderId, distanceKm, baseFee);
    }
    @Override
    public double calculateTotal(){
        double total= getBaseFee()+(getDistanceKm()*2.0);
        return total;
    }
}
