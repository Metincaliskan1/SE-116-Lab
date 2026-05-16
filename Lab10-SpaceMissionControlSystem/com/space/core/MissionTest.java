package com.space.core;

import com.space.exceptions.MissionDataException;
import com.space.mission.MissionTask;

public class MissionTest {
    public static void main(String[] args) {
        SpaceCraft apollo=new SpaceCraft("Apollo",80);
        SpaceCraft andromeda=new SpaceCraft("Andromeda",100);
        Astronaut alex=new Astronaut("Alex",1);
        Astronaut john=new Astronaut("John",5);

        MissionControl missionControl=new MissionControl( "Operation Artemis");

        MissionTask missionTask=new MissionTask("Orbit Insertion", 20, 1);
        MissionTask missionTask1=new MissionTask("Mars Cargo Delivery", 150, 2);
        MissionTask missionTask2=new MissionTask("Black Hole Research", 30, 8);
        missionControl.addAstronaut(alex);
        missionControl.addAstronaut(john);
        missionControl.addSpaceCraft(apollo);
        missionControl.addSpaceCraft(andromeda);
        missionControl.printMissionMembers();
        missionControl.removeAstronaut("Alex");
        missionControl.printMissionMembers();
        int initalExp= john.getExperienceLevel();
        try {
            missionControl.launchTask("Andromeda","John",missionTask);
            missionControl.emergencyCheck("System OK");
            assert andromeda.getFuelLevel()>=0:"Fuel level cannot be negative!";
            assert missionTask.getIsCompleted():"Task should be marked as completed!";
            assert john.getExperienceLevel()>initalExp:"Experience level did not increase!";
           // missionControl.launchTask("Apollo","John",missionTask1);
            //missionControl.launchTask("Apollo","Alex",missionTask);
            //missionControl.launchTask("Andromeda","John",missionTask2);

        }catch (MissionDataException | IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Cause: "+e.getCause());
        }
        String sampleLog = "MISSION LOG - Operation Artemis\n" +
                "Task: " + missionTask.getName() + "\n" +
                "Status: Processed successfully.\n" +
                "Remaining Fuel: " + andromeda.getFuelLevel();
        missionControl.exportMissionLog(sampleLog);

    }
}
