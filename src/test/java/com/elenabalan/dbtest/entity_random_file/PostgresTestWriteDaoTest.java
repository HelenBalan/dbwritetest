package com.elenabalan.dbtest.entity_random_file;

import com.elenabalan.dbtest.dao.PostgresTestWriteDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class PostgresTestWriteDaoTest {

    private PostgresTestWriteDao dao;
    private List<File> files = new LinkedList<>();

    @Before
    public void before(){
        files = RandomFile.createFiles(1000,1,"testfolder");

    }

    @Test
    public void putFiles() throws SQLException, IOException {
        dao = new PostgresTestWriteDao();
        dao.putFiles(files);
        assertNotNull(dao);
        assertNotNull(dao.getConnection());
        dao.clearDB();
    }

    @After
    public void after(){
        RandomFile.clearFiles(files);
    }
}
