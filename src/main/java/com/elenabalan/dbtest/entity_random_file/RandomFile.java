package com.elenabalan.dbtest.entity_random_file;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RandomFile {

    private RandomFile(){}

    static File createFile(long size, String dirName){

        File dir = new File(dirName);
        File file;
        String prefix = "pre" + Thread.currentThread().getName();
        try {
            file = File.createTempFile(prefix,"",dir);
        } catch (IOException e) {
            throw new IllegalStateException("Sorry, can't create file into " + dir.getName());
        }

        SecureRandom dataRandomGenerator = new SecureRandom();
        int realSize = (int) ((dataRandomGenerator.nextGaussian()+1.0)*size); // get a size of the file with normal distribution
                                                                            // between 0 and getting size * 2
        byte[] data = dataRandomGenerator.generateSeed(realSize);
        try {
            FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e) {
            throw new IllegalStateException("Sorry, can't write to file " + file.getName());
        } catch (NullPointerException e){
            throw new IllegalStateException("Sorry, data is null :(");
        }
        return file;
    }

    static List<File> createFiles(int size, int number, String dirName){

        new File(dirName).mkdirs();

        List<File> list = new LinkedList<>();

        for(int i=0; i<number; i++){
            list.add(createFile(size, dirName));
        }

        return list;
    }

    static void clearFiles(List<File> list){

        for(File file: list) {
            Path path = Paths.get(file.toURI());
            try {
                Files.delete(path);
            } catch (IOException e){
                throw new IllegalStateException("Can't delete file "+ file.getName() + ": " + e.getMessage());
            }
        }
    }
}
