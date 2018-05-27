package com.elenabalan.dbtest.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
@Qualifier("fakeData")
public class FakeTestWriteDao implements TestWriteDao {

    private static final String DIR_NAME = "testdata";
    private static final Path DIR = Paths.get(DIR_NAME);

    @Override
    public void putFile(Path file) {

         Path newFile = DIR.resolveSibling(file.getFileName());
         try {
             Files.copy(file, newFile);
         } catch (IOException e) {
             throw new IllegalStateException("Sorry, can't copy " + file.getFileName() + " to " + newFile.getFileName());
         }
    }

    @Override
    public void clearDB() {
        /* not implemented */
    }
}
