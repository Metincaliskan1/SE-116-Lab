
public class InternationalShipping extends Shipment{
    public InternationalShipping(String trackingNo,String contentType,int weightKg,int distanceKm){
        super(trackingNo, contentType, weightKg, distanceKm);
    }
    @Override
    public double calculateFee(){
        if (getDistanceKm()<=800){
            return  30.0 + 40.0 + 0.15 * this.getDistanceKm() + 3.0 * this.getWeightKg();
        }else  {
            return  30.0 + 40.0 + 0.15 * this.getDistanceKm() + 3.0 * this.getWeightKg() + 35.0;
        }
    }

    @Override
    public double finalFee(){
        if (getWeightKg()<10){
            return calculateFee()*97/100;
        }else return calculateFee();
    }
}
