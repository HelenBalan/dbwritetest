package com.elenabalan.dbtest.entityRandomFile;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class RandomFile {
    static File createFile(long size, String dirName){

        File dir = new File(dirName);
        File file;
        String prefix = Thread.currentThread().getName();
        try {
            file = File.createTempFile(prefix,"",dir);
        } catch (IOException e) {
            throw new RuntimeException("Sorry, can't create file into " + dir.getName());
        }

        SecureRandom dataRandomGenerator = new SecureRandom();
        int realSize = (int) ((dataRandomGenerator.nextGaussian()+1.0)*size); // get a size of the file with normal distribution
                                                                            // between 0 and getting size * 2
        byte[] data = dataRandomGenerator.generateSeed(realSize);
        try {
            FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e) {
            throw new RuntimeException("Sorry, can't write to file " + file.getName());
        } catch (NullPointerException e){
            if (data == null) throw new RuntimeException("Sorry, data is null :(");
        }
        return file;
    }

    static ArrayList<File> createFiles(int size, int number, String dirName){

        ArrayList<File> list = new ArrayList<>();

        for(int i=0; i<number; i++){
            list.add(createFile(size, dirName));
        }

        return list;
    }
}
