import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentDemo {
    static void main(String[] args) {


        StudentManager manager = new StudentManager();
        ArrayList<Student>Students=new ArrayList<>();
        Students.add(new Student(12345,"Metin",35.5,80));
        Students.add(new Student(12345,"Mehmet",65.8,60));
        Students.add(new Student(12345,"Kutay",86,45));
        Students.add(new Student(12345,"Ali",95,100));


        for (Student s:Students){
            s.displayInfo();

            if (manager.checkStudent(s, (std) -> std.getGrade()<=40 && std.getGrade()>=30)){
                s.setGrade(manager.applyGradeOperation(s, grade -> 40));
            }
            if(manager.checkStudent(s,(std)->std.getGrade()<=90&&std.getGrade()>=85)){
                s.setGrade(manager.applyGradeOperation(s,std->90));
            }
            if (manager.checkStudent(s,std->std.getGrade()>=75)){
                s.setGrade(manager.applyGradeOperation(s,grade -> grade+5));
            }

            System.out.println("Final grade");
            System.out.println(s.getGrade());
            if (manager.checkStudent(s,std->std.getGrade()>60)){
                System.out.println("PASSED");
            }
            else {
                System.out.println("FAİLED");
            }
            System.out.println("----------------");
        }
        Collections.sort(Students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getGrade(), o1.getGrade());
            }
        });

        for (Student s:Students){
            System.out.println(s.getGrade());
        }



    }
}
