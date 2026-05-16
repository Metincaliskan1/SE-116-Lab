package com.space.mission;

public class MissionTask {
    private String name;
    private int requiredFuel;
    private int requiredExperience;
    private boolean isCompleted;

    public MissionTask(String name,int requiredFuel,int requiredExperience){
        this.name=name;
        this.requiredFuel=requiredFuel;
        this.requiredExperience=requiredExperience;
        this.isCompleted=false;
    }

    public String getName() {
        return name;
    }

    public int getRequiredFuel() {
        return requiredFuel;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRequiredExperience(int requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public void setRequiredFuel(int requiredFuel) {
        this.requiredFuel = requiredFuel;
    }
    public boolean getIsCompleted(){
        return isCompleted;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+"Required Fuel: "+getRequiredFuel()+"Required Experince:  "+getRequiredExperience()+"Is completed: "+getIsCompleted();
    }



}
