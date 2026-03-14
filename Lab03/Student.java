public class Student implements Comparable<Student>{
    private int studentID;
    private String name;
    private double gpa;

    public Student(int studentID,String name,double gpa){
        this.gpa=gpa;
        this.name=name;
        this.studentID=studentID;
    }

    public int getStudentID(){
        return this.studentID;
    }
    public void setStudentID(int studentID){
        this.studentID=studentID;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getGpa(){
        return this.gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void printInfo(){

        System.out.println("Student name: "+getName());
        System.out.println("Student ID: "+getStudentID());
        System.out.println("Student gpa: "+getGpa());
        System.out.println("------------------------");
    }




    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentID,other.studentID);
    }

    @Override
    public String toString(){
        return "ID:"+getStudentID()+" | Name:"+getName()+" | Gpa:"+getGpa();
    }
}
