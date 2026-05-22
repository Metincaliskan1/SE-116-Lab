import java.io.Serializable;

public class ScoreRecord implements Serializable {
    private String name;
    private int score;
    public ScoreRecord(String name,int score){
        if (score<0||score>100){
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
        this.name=name;
        this.score=score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString(){
        return "Name: "+getName()+"\nScore: "+getScore();
    }
}
