public class StandardShipping extends Shipment{
    public StandardShipping(String trackingNo,String contentType,int weightKg,int distanceKm){
        super(trackingNo, contentType, weightKg, distanceKm);
    }
    @Override
    public double calculateFee(){
        return  15.0 + 0.08 * this.getDistanceKm() + 1.5 * this.getWeightKg();
    }

    @Override
    public double finalFee(){
        if (getDistanceKm()<200){
            return calculateFee()*95/100;
        }else return calculateFee();
    }

}
