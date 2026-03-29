import java.util.ArrayList;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<Content>Contents=new ArrayList<>();

        Contents.add(new Movie(123456,"Harry Poter",200,true));
        Contents.add(new Movie(3532,"Lord of the rings",120,false));

        Contents.add(new Series(5325,"Friends",20,70));
        Contents.add(new Series(4436,"How I met your mother",25,50));

        Contents.add(new Documentary(1231,"Document1",50,2,10));
        Contents.add(new Documentary(5462,"Document2",28,5,5));

        for (Content c:Contents){
            c.displayInfo();
            System.out.println("Total Duration: "+c.calculateTotalDuration());
            System.out.println("Category: "+c.getRecommendationCategory());
            System.out.println("----------------");
        }


    }
}
