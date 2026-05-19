package com.labmanager.service;

import com.labmanager.model.StudentRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class RecordManager {

    public static ArrayList<StudentRecord> readRecords(Path inputPath){
        ArrayList<StudentRecord>Students=new ArrayList<>();
        try(BufferedReader reader= Files.newBufferedReader(inputPath)){
            String line;

            while ((line=reader.readLine())!=null){
                String[] records=line.split(",");

                if (records.length==5){
                    try{
                        String id=records[0];
                        String name=records[1];
                        int lab=Integer.parseInt(records[2]);
                        double score=Double.parseDouble(records[3]);
                        String password=records[4];
                        Students.add(new StudentRecord(id,name,lab,score,password));
                    }catch (NumberFormatException e){
                        System.out.println("Warning: Skipped line due to invalid numeric values.");
                    }
                }else {
                    System.out.println("Skipped line due to missing fields.");

                }

            }
        }catch (IOException e){
            System.out.println("Error reading file: "+e.getMessage());
        }
        return Students;
    }

    public static void writeSuccessfulReport(ArrayList<StudentRecord> records, Path reportPath){
        try(BufferedWriter writer=Files.newBufferedWriter(reportPath);) {
            writer.write("===Successful Students===");
            writer.newLine();
            for (StudentRecord std:records){
                if (std.isSuccessful()){
                    writer.write(std.getInfo());
                    writer.newLine();
                }
            }
        }catch (IOException e){
            System.out.println("Error writing file: "+e.getMessage());
        }
    }

    public static void writeSummaryReport(ArrayList<StudentRecord> records, Path summaryPath){
        try(BufferedWriter writer=Files.newBufferedWriter(summaryPath)) {
            writer.write("=== Class Summary ===");
            writer.newLine();
            writer.write("Total number of loaded students: "+records.size());
            writer.newLine();
            int successfulStd=0;
            int unsuccessfulStd=0;
            double TotalScore=0;
            for (StudentRecord std:records){
                TotalScore=std.getAverageScore()+TotalScore;
                if (std.isSuccessful()){
                    successfulStd++;
                }else {
                    unsuccessfulStd++;
                }
            }
            writer.write("The number of successful students: "+successfulStd);
            writer.newLine();
            writer.write("the number of unsuccessful students: "+unsuccessfulStd);
            writer.newLine();


            writer.write("The class average score: "+TotalScore/records.size());


        }catch (IOException e){
            System.out.println("Error writing file: "+e.getMessage());
        }
    }

    public static void serializeRecords(ArrayList<StudentRecord> records, Path backupPath){
        try(ObjectOutputStream outputStream=new ObjectOutputStream(Files.newOutputStream(backupPath))){
            outputStream.writeObject(records);

        }catch (IOException e){
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
    public static ArrayList<StudentRecord> deserializeRecords(Path backupPath){
        try(ObjectInputStream inputStream=new ObjectInputStream(Files.newInputStream(backupPath))){
            return (ArrayList<StudentRecord>) inputStream.readObject();

        }catch (IOException  e){
            System.out.println("Reading error: "+e.getMessage());

        }catch (ClassNotFoundException e){
            System.out.println("Class could not found: "+e.getMessage());

        }return null;

    }



}
