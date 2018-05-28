package com.elenabalan.dbtest.entity_random_file;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SecureRandom.class, RandomFile.class, File.class, FileUtils.class, Files.class})
public class RandomFileTest {

    private SecureRandom mockRundom;
    private File file;

    private final long size = 1000;
    private final String dirName = "testfolder";

    @Before
    public void setUp() throws Exception {

        mockRundom = PowerMockito.mock(SecureRandom.class);
        when(mockRundom.nextGaussian()).thenReturn(-1.0).thenReturn(0.0).thenReturn(1.0);
        when(mockRundom.generateSeed(0)).thenReturn(new byte[0]);
        when(mockRundom.generateSeed(1000)).thenReturn(new byte[1000]);
        when(mockRundom.generateSeed(2000)).thenReturn(new byte[2000]);

        PowerMockito.whenNew(SecureRandom.class).withNoArguments().thenReturn(mockRundom);

        File newDir = new File(dirName);
        boolean isDir = newDir.mkdir();
    }

    @Test
    public void createFile() {

        for (int i = 0; i < 3; i++) {
            File newFile;
            newFile = RandomFile.createFile(size, dirName);
            assertTrue(newFile.exists());
            long realSize = newFile.length();
            boolean isFileDeleted = newFile.delete();
            if(!isFileDeleted) {
                throw new IllegalStateException("Can't delete file "+ newFile.getName());
            }
            assertTrue(realSize == size * i);
        }
    }

    @Test(expected = IllegalStateException.class)
    public void createFileCreationException() throws Exception {

        PowerMockito.mockStatic(File.class);

        PowerMockito.when(File.createTempFile(anyString(),anyString(),anyObject())).thenThrow(new IOException());
        File newFile = RandomFile.createFile(size, dirName);
    }

    @Test(expected = IllegalStateException.class)
    public void createFileFillException() throws Exception {

        PowerMockito.mockStatic(FileUtils.class);

        doThrow(new IOException()).when(FileUtils.class,"writeByteArrayToFile",anyObject(), anyObject());

        File newFile = RandomFile.createFile(size, dirName);
    }

    @Test(expected = IllegalStateException.class)
    public void createFileEmptyException() throws Exception {

        PowerMockito.mockStatic(FileUtils.class);

        doThrow(new NullPointerException()).when(FileUtils.class,"writeByteArrayToFile",anyObject(), anyObject());

        File newFile = RandomFile.createFile(size, dirName);
    }

    @Test
   public void createFiles() {

        final int numberOfFile = 1000;
        final String dirName = "testfolder";

        List<File> files;
        files = RandomFile.createFiles(1000,numberOfFile,dirName);
        int realNumber = files.size();
        assertEquals(realNumber,numberOfFile);
    }

    @Test
    public void clearFiles() throws Exception {

        final int numberOfFiles = 10;
        final String testName = "testName";

        PowerMockito.mockStatic(Files.class);

        List<File> files = new ArrayList<>();
        for(int i=0;i<numberOfFiles;i++){
            files.add(new File(testName+i));
        }
        RandomFile.clearFiles(files);
        verifyStatic(Files.class,times(numberOfFiles));
        Files.delete(anyObject());
    }

    @Test(expected = IllegalStateException.class)
    public void clearFilesError() throws Exception {

        final int numberOfFiles = 10;
        final String testName = "testName";

        PowerMockito.mockStatic(Files.class);

        List<File> files = new ArrayList<>();
        for(int i=0;i<numberOfFiles;i++){
            files.add(new File(testName+i));
        }

        doThrow(new IOException()).when(Files.class);
        Files.delete(anyObject());

        RandomFile.clearFiles(files);
    }

    @After
    public void tearDown() {
        File newDir = new File(dirName);
        try {
            FileUtils.deleteDirectory(newDir);
        } catch (IOException e) {
            throw new IllegalStateException("Cant' delete dir " + dirName);
        }
    }
}