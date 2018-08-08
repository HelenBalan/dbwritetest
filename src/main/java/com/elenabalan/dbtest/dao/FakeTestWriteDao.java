package com.elenabalan.dbtest.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Repository
@Qualifier("fakeData")
public class FakeTestWriteDao implements TestWriteDao {

    private static final String DIR_NAME = "testdata";
    private static final Path DIR = Paths.get(DIR_NAME);

    public void putFile(Path file) {

         Path newFile = DIR.resolveSibling(file.getFileName());
         try {
             Files.copy(file, newFile);
         } catch (IOException e) {
             throw new IllegalStateException("Sorry, can't copy " + file.getFileName() + " to " + newFile.getFileName());
         }
    }

    @Override
    public void putFiles(List<File> files) throws SQLException {

    }

    @Override
    public void clearDB() {
        /* not implemented */
    }
}
