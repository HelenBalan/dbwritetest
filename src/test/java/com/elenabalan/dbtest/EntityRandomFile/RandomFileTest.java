package com.elenabalan.dbtest.EntityRandomFile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SecureRandom.class, RandomFile.class})
public class RandomFileTest {

    private SecureRandom mockRundom;

    @Before
    public void setUp() throws Exception {

        mockRundom = PowerMockito.mock(SecureRandom.class);
        when(mockRundom.nextGaussian()).thenReturn(-1.0).thenReturn(0.0).thenReturn(1.0);
        when(mockRundom.generateSeed(0)).thenReturn(new byte[0]);
        when(mockRundom.generateSeed(1000)).thenReturn(new byte[1000]);
        when(mockRundom.generateSeed(2000)).thenReturn(new byte[2000]);

        PowerMockito.whenNew(SecureRandom.class).withNoArguments().thenReturn(mockRundom);
    }

    @Test
    public void createFile() throws Exception {

        final long size = 1000;
        final long maxSize = size*2;
        final String dirName = "testfolder";

        File newDir = new File(dirName);
        newDir.mkdir();
        for (int i=0; i<3; i++) {
            File newFile;
            newFile = RandomFile.createFile(size, dirName);
            assertTrue(newFile.exists());
            long realSize = newFile.length();
            newFile.delete();
            assertTrue(realSize == size*i);
        }

    }

    @Test
   public void createFiles() throws Exception {

        final int numberOfFile = 1000;
        final String dirName = "testfolder";

        List<File> files = new ArrayList<>();
        files = RandomFile.createFiles(1000,numberOfFile,dirName);
        int realNumber = files.size();
        assertEquals(realNumber,numberOfFile);
    }
}