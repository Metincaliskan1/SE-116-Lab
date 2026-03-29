public class Shipment {
    private String trackingNo;
    private String contentType;
    private int weightKg;
    private int distanceKm;

    public Shipment(String trackingNo,String contentType,int weightKg,int distanceKm){
        this.trackingNo=trackingNo;
        this.contentType=contentType;
        this.weightKg=weightKg;
        this.distanceKm=distanceKm;
    }

    public String getTrackingNo(){
        return trackingNo;
    }
    public void setTrackingNo(String trackingNo){
        this.trackingNo=trackingNo;
    }
    public int getDistanceKm() {
        return distanceKm;
    }
    public void setDistanceKm(int distanceKm) {
        this.distanceKm = distanceKm;
    }
    public int getWeightKg() {
        return weightKg;
    }
    public void setWeightKg(int weightKg) {
        this.weightKg = weightKg;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public double calculateFee(){
        return 1;
    }

    public void  printReceipt(){
        System.out.println("Tracking no: "+getTrackingNo());
        System.out.println("Distance(km): "+getDistanceKm());
        System.out.println("Weight: "+getWeightKg());
        System.out.println("Content type: "+getContentType());
        System.out.println("Fee: "+calculateFee());
        System.out.println("Discounted fee: "+finalFee());
        System.out.println("Shipment type: "+this.getClass().getName());
    }

    public double finalFee(){
        return calculateFee();
    }




}
