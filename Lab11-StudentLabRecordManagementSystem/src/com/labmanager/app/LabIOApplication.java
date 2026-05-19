package com.labmanager.app;

import com.labmanager.model.StudentRecord;
import com.labmanager.service.BackupManager;
import com.labmanager.service.RecordManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LabIOApplication {
    public static void main(String[] args) {

        Path inputPath= Paths.get("data","students.txt");
        Path outputDir=Paths.get("output");
        Path successfulReportPath=Paths.get("output","successful_students.txt");
        Path summaryPath = Paths.get("output", "summary.txt");
        Path textBackupPath = Paths.get("output", "students_backup.txt");
        Path objectBackupPath = Paths.get("output", "student_records.ser");
        Path logPath = Paths.get("output", "log.txt");

        if (!Files.exists(outputDir)) {
            try {
                Files.createDirectories(outputDir);
            } catch (IOException e) {
                System.out.println("File could not wrote");
            }
        }
        if (!BackupManager.fileExists(inputPath)){
            System.out.println("Input file not found: "+inputPath);
            return;
        }
        BackupManager.appendLog(logPath, "Application started.");
        ArrayList<StudentRecord>records=RecordManager.readRecords(inputPath);
        for (StudentRecord std:records){
            System.out.println(std.getInfo());
            System.out.println("----------");
        }

        RecordManager.writeSuccessfulReport(records,successfulReportPath);
        RecordManager.writeSummaryReport(records,summaryPath);

        BackupManager.copyInputFile(inputPath,textBackupPath);

        System.out.println("Backup file size :"+BackupManager.getFileSize(textBackupPath)+" bytes.");

        BackupManager.appendLog(logPath, "Reports generated and input file backed up successfully.");

        RecordManager.serializeRecords(records,objectBackupPath);
        System.out.println("=== Reading from Serialized File ===");
        if (RecordManager.deserializeRecords(objectBackupPath)!=null){
            for (StudentRecord std:RecordManager.deserializeRecords(objectBackupPath)){
                System.out.println(std.getInfo());
                System.out.println("---------------");
            }
        }

        BackupManager.appendLog(logPath, "Application finished successfully.");







    }
}
