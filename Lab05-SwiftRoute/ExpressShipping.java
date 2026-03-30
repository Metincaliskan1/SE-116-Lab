public class ExpressShipping extends Shipment{
    public ExpressShipping(String trackingNo,String contentType,int weightKg,int distanceKm){
        super(trackingNo, contentType, weightKg, distanceKm);
    }

    @Override
    public double calculateFee(){
        return  20.0 + 25.0 + 0.12 * this.getDistanceKm() + 2.2 * this.getWeightKg();
    }

    public void printExpressNote(){
        System.out.println("Express Notes...");
    }

    @Override
    public double finalFee(){
        return calculateFee();
    }


}
