import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Task2Main {
    public static void main(String[] args) {
        ArrayList<ScoreRecord>scores=new ArrayList<>();
        ArrayList<ScoreRecord> loadedScores=new ArrayList<>();
        int score=0;
        String name=null;
        try(BufferedReader br= Files.newBufferedReader(Paths.get("scores.txt"))){
            String line;
            while ((line=br.readLine())!=null){
                String[] variables=line.split(",");
                if (variables.length!=2){
                    continue;
                }
                if (variables[0].equals("")){
                    continue;
                }else {
                    name=variables[0];
                       try  {
                           score=Integer.parseInt(variables[1]);
                           scores.add(new ScoreRecord(name,score));

                       } catch (NumberFormatException e){
                           System.out.println("Student "+name + "s score is invalid: Score must be integer.");


                       }catch (IllegalArgumentException e){
                           System.out.println(e.getMessage());

                       }
                }
            }

        }catch (IOException e){
            System.out.println("File couldnt read: "+e.getMessage());
        }
        for (ScoreRecord sr:scores){
            System.out.println(sr.toString());
        }
        try (ObjectOutputStream outputStream=new ObjectOutputStream(Files.newOutputStream(Paths.get("scores.ser")))){
            outputStream.writeObject(scores);
        }catch (IOException e){
            System.out.println("Could not write: "+e.getMessage());
        }
        try(ObjectInputStream inputStream=new ObjectInputStream(Files.newInputStream(Paths.get("scores.ser")))) {

            loadedScores= (ArrayList<ScoreRecord>) inputStream.readObject();
        }catch (IOException e){
            System.out.println("Could not read: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
        System.out.println("--- Serialization List ---");
        for (ScoreRecord record:loadedScores){
            System.out.println(record.toString());
        }

    }
}
