public class Documentary extends Content {
    private int researchDepthLevel;
    private int numberOfScientistInterviews;

    public Documentary(int id,String title,int baseDuration,int researchDepthLevel,int numberOfScientistInterviews){
        super(id, title, baseDuration);
        if (researchDepthLevel<=5&&researchDepthLevel>=1){
            this.researchDepthLevel=researchDepthLevel;
        }
        else {
            this.researchDepthLevel=1;
        }
        this.numberOfScientistInterviews=numberOfScientistInterviews;
    }

    public int getResearchDepthLevel() {
        return researchDepthLevel;
    }

    public int getNumberOfScientistInterviews() {
        return numberOfScientistInterviews;
    }

    @Override
    public int calculateTotalDuration(){
        return getBaseDuration()+(numberOfScientistInterviews*10);
    }

    @Override
    public String getRecommendationCategory() {
        if (getResearchDepthLevel()>=4){
            return "In-Depth";
        }else {
            return  "Light Informative";
        }
    }



}
