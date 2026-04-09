public class Student {
    private int id;
    private String name;
    private double grade;
    private int performanceGrade;

    public Student(int id,String name,double grade,int performanceGrade){
        this.id=id;
        this.name=name;
        this.grade=grade;
        this.performanceGrade=performanceGrade;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public int getId() {
        return id;
    }
    public int getPerformanceGrade() {
        return performanceGrade;
    }
    public String getName() {
        return name;
    }

    public void displayInfo(){
        System.out.println("Id: "+getId());
        System.out.println("Name: "+getName());
        System.out.println("Grade: "+getGrade());
        System.out.println("Performance Grade: "+getPerformanceGrade());
    }




}
