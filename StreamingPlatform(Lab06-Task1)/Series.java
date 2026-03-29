public class Series extends Content{
    private int numberOfEpisodes;

    public Series(int id,String title,int baseDuration,int numberOfEpisodes){
        super(id, title, baseDuration);
        this.numberOfEpisodes=numberOfEpisodes;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    @Override
    public int calculateTotalDuration(){
        return getBaseDuration()*numberOfEpisodes;
    }

    @Override
    public String getRecommendationCategory() {
        if (getNumberOfEpisodes()>=10){
            return "Binge Worthy";
        }
        else {
            return "Mini Series";
        }
    }


}
