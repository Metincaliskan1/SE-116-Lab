public abstract class Delivery {
    private String  orderId;
    private double distanceKm;
    private double baseFee;
    public Delivery(String orderId,double distanceKm,double baseFee){
        this.orderId=orderId;
        this.distanceKm=distanceKm;
        this.baseFee=baseFee;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public abstract double calculateTotal();

    public void printReceipt(){
        System.out.println("Id: "+getOrderId());
        System.out.println("Distance: "+getDistanceKm());
        System.out.println("Fee: "+getBaseFee());
        System.out.println("Total: "+calculateTotal());
    }
    @Override
    public String toString() {
        return "Delivery ID: " + getOrderId() + ", Distance: " + getDistanceKm() +
                "km, Base Fee: " + getBaseFee() + ", Total: " + calculateTotal();
    }
}
