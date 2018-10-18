package com.elenabalan.dbtest.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface TestWriteDao {

    void putFiles(List<byte[]> data) throws SQLException, IOException;

    void clearDB() throws SQLException;

}
