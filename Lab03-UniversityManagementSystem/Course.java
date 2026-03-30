import java.util.ArrayList;
import java.util.Locale;

public class Course{
    private int courseCode;
    private String courseName;
    private ArrayList<Student>enrolledStudents;
    private ArrayList<Student>probationList;


    public Course(int courseCode,String courseName){
        this.courseCode=courseCode;
        this.courseName=courseName;
        enrolledStudents= new ArrayList<>();
        probationList= new ArrayList<>();

    }
    public ArrayList<Student> getEnrolledList(){
        return enrolledStudents;
    }

    public void addStudent(Student student){
        enrolledStudents.add(student);
    }
    public void  displayEnrolledStudents(){
        for (int i=0;i<enrolledStudents.size();i++){
            enrolledStudents.get(i).printInfo();
        }
    }
    public void removeStudentByID(int id){
        for (int i=0;i<enrolledStudents.size();i++){
            if (id==enrolledStudents.get(i).getStudentID()){
                enrolledStudents.remove(i);

            }
            if (id!=enrolledStudents.get(i).getStudentID()){
                System.out.println("Error: Student not found in this course.");
                break;
            }
        }
    }
    public void filterProbation(){
        for (int i=enrolledStudents.size()-1;i>=0;i--){
            Student student = enrolledStudents.get(i);
            if (student.getGpa()<2){
                probationList.add(student);
                enrolledStudents.remove(i);
            }
        }
    }
    public ArrayList<Student> searchByName(String keyword){
        ArrayList<Student> results= new ArrayList<>();
        for (int i=0;i<enrolledStudents.size();i++){
            if (enrolledStudents.get(i).getName().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))){
                results.add(enrolledStudents.get(i));
            }

        }
        for (int i=0;i<probationList.size();i++){
            if (probationList.get(i).getName().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))){
                results.add(probationList.get(i));
            }
        }

        return results;
    }








}
