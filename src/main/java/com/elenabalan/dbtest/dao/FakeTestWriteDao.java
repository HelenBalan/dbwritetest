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

    final private String dirName = "testdata";
    final private Path dir = Paths.get(dirName);

    @Override
    public void PutFile(Path file) {

         Path newFile = dir.resolveSibling(file.getFileName());
         try {
             Files.copy(file, newFile);
         } catch (IOException e) {
             throw new RuntimeException("Sorry, can't copy " + file.getFileName() + " to " + newFile.getFileName());
         }
    }

    @Override
    public void ClearDB() {

    }
}
