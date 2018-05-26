package com.elenabalan.dbtest.Dao;

import com.elenabalan.dbtest.EntityRandomFile.RandomFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface TestWriteDao {

    void PutFile(Path path);

    void ClearDB();

}
