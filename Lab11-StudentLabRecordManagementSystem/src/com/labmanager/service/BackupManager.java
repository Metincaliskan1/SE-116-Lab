package com.labmanager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class BackupManager {

    public static boolean fileExists(Path path){
        return Files.exists(path);
    }
    public static void copyInputFile(Path sourcePath, Path destinationPath){
        try{
            Files.copy(sourcePath,destinationPath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
    public static long getFileSize(Path path){
        try{
            return Files.size(path);
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
        return 0;
    }
    public static void appendLog(Path logPath, String message){
        try {
            Files.writeString(logPath, message + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        }catch (IOException e){
            System.out.println("Error writing file: "+e.getMessage());

        }
    }

}
