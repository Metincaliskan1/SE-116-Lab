import java.util.Collections;

public class EnrollmentDemo {
    public static void main(String[] args){
        Student student1= new Student(12345536,"Kutay",2.93);
        Student student2= new Student(12345678,"İdil",2.73);
        Student student3= new Student(12345680,"Metin",3.23);
        Student student4= new Student(12345680,"Mehmet",1.30);
        Student student5= new Student(12345230,"Memet",3.4);
        Course course1 = new Course(12345667,"SE 116");

        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addStudent(student3);
        course1.addStudent(student4);

        Collections.sort(course1.getEnrolledList(),new GpaComparator());

        course1.filterProbation();





        course1.displayEnrolledStudents();











    }
}
