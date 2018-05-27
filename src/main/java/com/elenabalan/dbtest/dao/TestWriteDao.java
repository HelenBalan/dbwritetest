package com.elenabalan.dbtest.dao;

import java.nio.file.Path;

public interface TestWriteDao {

    void PutFile(Path path);

    void ClearDB();

}
