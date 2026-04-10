public class Song {
    private String title;
    private String artist;
    private double duration;
    private double rating;
    private Boolean isHighRated;

    public Song(String title,String artist,int duration,double rating){
        this.title=title;
        this.artist=artist;
        this.duration=duration;
        this.rating=rating;
        if (rating>9){
            isHighRated=true;
        }else {
            isHighRated=false;
        }
    }
    public void displayInfo(){
        System.out.println("Title: "+getTitle());
        System.out.println("Artist: "+getArtist());
        System.out.println("Duration: "+getDuration());
        System.out.println("Rating: "+getRating());
        System.out.println("High Rated: "+getIsHighRated());
    }
    public boolean getIsHighRated(){
        return isHighRated;
    }
    public void setIsHighRated(Boolean b){
        isHighRated=b;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }



}
