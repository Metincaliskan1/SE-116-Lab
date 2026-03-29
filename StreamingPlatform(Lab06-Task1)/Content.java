public abstract class Content {
    private int id;
    private String title;
    private int baseDuration;

    public Content(int id,String title,int baseDuration){
        this.id=id;
        this.title=title;
        this.baseDuration=baseDuration;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getBaseDuration() {
        return baseDuration;
    }
    public void setBaseDuration(int baseDuration) {
        this.baseDuration = baseDuration;
    }

    public void displayInfo(){
        System.out.println("Content ID: "+getId());
        System.out.println("Title: "+getTitle());
        System.out.println("Base duration: "+getBaseDuration());
    }

    public abstract int calculateTotalDuration();
    public abstract String getRecommendationCategory();




}
