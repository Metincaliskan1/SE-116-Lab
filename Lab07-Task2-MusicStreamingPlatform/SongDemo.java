import java.util.ArrayList;
import java.util.Collections;

public class SongDemo {
    public static void main(String[] args) {

        //rateing sıraala
        //isme göre sıralıcaz
        ArrayList<Song>Songs=new ArrayList<>();
        SongManager Manager=new SongManager();
        Songs.add(new Song("In Da Club","50 cent",204,9.8));
        Songs.add(new Song("Without Me","Eminem",178,8.5));
        Songs.add(new Song("Drop It Like It's Hot","Snoop Dogg",190,6.4));
        Songs.add(new Song("Beat It","Michael Jackson",110,3.9));

        for (Song s:Songs){
            s.displayInfo();
            System.out.println("---Updated Rating---");
            if (s.getRating()<9.5){
                s.setRating(Manager.applyRatingOperation(s,sng->sng+0.5));
            }
            if (Manager.checkSong(s,sng->sng.getRating()>=9.0)){
                s.setIsHighRated(true);
            }
            System.out.println(s.getRating());
            System.out.println("High rated: "+s.getIsHighRated());
            System.out.println("-------------");
        }
        System.out.println();

        System.out.println("----------Sorted by Rate----------");
        System.out.println();
        Collections.sort(Songs,(s1,s2)->Double.compare( s2.getRating(),s1.getRating()));
        for (Song s:Songs){
            System.out.println("Name"+s.getTitle());
            System.out.println("Rate:"+s.getRating());
            System.out.println("--------------");
        }
        System.out.println();

        System.out.println("---------------Sorted by Title---------------");
        Collections.sort(Songs,(s1,s2)-> s1.getTitle().compareTo(s2.getTitle()));
        System.out.println();
        for (Song s:Songs){
            System.out.println("Name: "+s.getTitle());
            System.out.println("--------------");
        }



    }
}
