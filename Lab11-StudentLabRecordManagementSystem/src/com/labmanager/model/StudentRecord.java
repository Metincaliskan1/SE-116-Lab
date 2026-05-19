package com.labmanager.model;

import java.io.Serializable;

public class StudentRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentID;
    private String name;
    private int completedLabs;
    private double averageScore;
    private transient String temporaryPassword;

    public StudentRecord(String studentID,String name,int completedLabs,double averageScore,String temporaryPassword ){
        this.studentID=studentID;
        this.name=name;
        this.completedLabs=completedLabs;
        this.averageScore=averageScore;
        this.temporaryPassword=temporaryPassword;
    }

    public double getAverageScore() {
        return averageScore;
    }
    public String getName() {
        return name;
    }
    public int getCompletedLabs() {
        return completedLabs;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getTemporaryPassword() {
        return temporaryPassword;
    }
    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    public void setCompletedLabs(int completedLabs) {
        this.completedLabs = completedLabs;
    }
    public void setTemporaryPassword(String temporaryPassword) {
        this.temporaryPassword = temporaryPassword;
    }

    public boolean isSuccessful(){
        if (completedLabs>=7&&averageScore>=60.0){
            return true;
        }else return false;
    }
    public String getInfo(){
        return "Id: "+getStudentID()+"\nName: "+getName()+"\nCompleted Labs: "+getCompletedLabs()+"\nScore: "+getAverageScore()+"\nTemporary Password: "+getTemporaryPassword();
    }
}

