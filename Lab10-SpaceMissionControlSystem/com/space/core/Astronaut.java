package com.space.core;

import com.space.mission.MissionTask;

public class Astronaut {
    private String name;
    private int experienceLevel;
    public Astronaut(String name, int experienceLevel){
        this.name=name;
        this.experienceLevel=experienceLevel;
    }

    public String getName() {
        return name;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
    public void performTask(MissionTask task){
        System.out.println( getName()+"astronaut is attempting the task");
        if(getExperienceLevel()>=task.getRequiredExperience()){
            System.out.println("The task completed");
            task.setCompleted(true);
            setExperienceLevel(getExperienceLevel()+1);
        }else {
            throw new RuntimeException("Astronaut "+getName()+" does not have enough experience for this task.");

        }
    }
}
