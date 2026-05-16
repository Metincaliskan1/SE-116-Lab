package com.space.core;

import com.space.exceptions.InsufficientFuelException;
import com.space.exceptions.MissionDataException;
import com.space.mission.MissionTask;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MissionControl {
    private String missionName;
    private ArrayList<SpaceCraft> spacecrafts;
    private ArrayList<Astronaut> astronauts;
    public MissionControl(String missionName){
        this.missionName=missionName;
        this.spacecrafts=new ArrayList<>(0);
        this.astronauts=new ArrayList<>(0);
    }

    public void addSpaceCraft(SpaceCraft sc){
        spacecrafts.add(sc);
    }

    public SpaceCraft getSpacecraft(String craftName){
        for (SpaceCraft sc:spacecrafts){
            if (sc.getCraftName().equals(craftName)){
                return sc;
            }
        }
        return null;
    }
    public void removeSpacecraft(String craftName){
        SpaceCraft spaceCraft =getSpacecraft(craftName);
        if (spaceCraft!=null){
            spacecrafts.remove(spaceCraft);
        }else {
            System.out.println("Space craft not found.");
        }
    }

    public void addAstronaut(Astronaut astronaut){
        astronauts.add(astronaut);
    }

    public Astronaut getAstronaut(String astronautName){
        for (Astronaut a:astronauts){
            if (a.getName().equals(astronautName)){
                return a;
            }
        }
        return null;
    }
    public void removeAstronaut(String astronautName){
        Astronaut astToDelete=getAstronaut(astronautName);
        if (astToDelete!=null){
            astronauts.remove(astToDelete);
        }else {
            System.out.println("Astronaut not found.");
        }


    }

    public void  printMissionMembers(){
        for (Astronaut a:astronauts){
            System.out.println("Astronaut name: "+a.getName());
            System.out.println("------");
        }
        for (SpaceCraft sc:spacecrafts){
            System.out.println("Space Craft Name: "+sc.getCraftName());
            System.out.println("---------");
        }
    }

    public  void launchTask(String craftName, String astronautName, MissionTask task)throws MissionDataException{
        try{
            getSpacecraft(craftName);
            getAstronaut(astronautName);

            getSpacecraft(craftName).executeTask(task);
            getAstronaut(astronautName).performTask(task);
        }catch (InsufficientFuelException e){
            throw new MissionDataException("Not enough fuel ",e);
        } catch (NullPointerException e) {
            throw new MissionDataException("Missing astronaut or spacecraft ",e);
        } catch (RuntimeException e) {
            throw new MissionDataException("Insufficient astronaut experience ",e);
        }finally {
            System.out.println("Mission control finished processing task: "+task.getName());
        }

    }
    public void exportMissionLog(String logText){


        try(PrintWriter out = new PrintWriter(new FileWriter("logs.txt"));){

            out.println(logText);

        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }


    }
    public void emergencyCheck(String systemCode){
        if (systemCode.equals("null")){
            throw new NullPointerException();
        }else if (systemCode.length()<3){
            throw new IllegalArgumentException();
        }else {
            System.out.println("The system code is valid.");
        }

    }




}
