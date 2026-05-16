package com.space.core;

import com.space.exceptions.InsufficientFuelException;
import com.space.mission.MissionTask;

public class SpaceCraft {
    private String craftName;
    private int fuelLevel;
    public SpaceCraft(String craftName, int fuelLevel){
        this.craftName=craftName;
        this.fuelLevel=fuelLevel;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public String getCraftName() {
        return craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    @Override
    public String toString(){
        return "Craft Name: " +getCraftName()+"\\nFuel Level: "+getFuelLevel();
    }
    public void executeTask(MissionTask task) throws InsufficientFuelException{
        if (getFuelLevel()>= task.getRequiredFuel()){
            setFuelLevel(getFuelLevel()- task.getRequiredFuel());
            System.out.println("success");
        }else {
            throw new InsufficientFuelException();
        }
    }

}
