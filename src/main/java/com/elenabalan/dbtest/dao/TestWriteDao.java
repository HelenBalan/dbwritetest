package com.elenabalan.dbtest.dao;

import java.nio.file.Path;

public interface TestWriteDao {

    void putFile(Path path);

    void clearDB();

}
