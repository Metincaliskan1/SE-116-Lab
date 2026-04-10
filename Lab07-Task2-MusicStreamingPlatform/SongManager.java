public class SongManager {
    public double applyRatingOperation(Song song,Rating operation){
        return operation.apply(song.getRating());
    }
    public boolean checkSong(Song s,SongChecker checker){
        return checker.check(s);
    }

    


}
