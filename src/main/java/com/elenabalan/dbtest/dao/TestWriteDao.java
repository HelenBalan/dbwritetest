package com.elenabalan.dbtest.dao;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TestWriteDao {

    void putFiles(List<File> files) throws SQLException, IOException;

    void clearDB() throws SQLException;

}
