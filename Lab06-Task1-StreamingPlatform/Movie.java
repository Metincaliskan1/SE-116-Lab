public class Movie extends Content{
    private Boolean hasPostCreditScene;

    public Movie(int id,String title,int baseDuration,Boolean hasPostCreditScene){
        super(id, title, baseDuration);
        this.hasPostCreditScene=hasPostCreditScene;
    }

    public Boolean getHasPostCreditScene() {
        return hasPostCreditScene;
    }

    @Override
    public int calculateTotalDuration(){
        if (hasPostCreditScene){
            return getBaseDuration()+5;
        }
        else{
            return getBaseDuration();
        }
    }

    @Override
    public String getRecommendationCategory(){
        if (getBaseDuration()<90){
            return "Short watch";
        }
        else {
            return "Feature Length";
        }
    }








}
