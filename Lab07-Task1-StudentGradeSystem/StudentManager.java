public class StudentManager {
    public double applyGradeOperation(Student s,GradeOperation operation){
        return operation.apply(s.getGrade());
    }
    public boolean checkStudent(Student s,StudentChecker checker){
        return checker.check(s);

    }
}
