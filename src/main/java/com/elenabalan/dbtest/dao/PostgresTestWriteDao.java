package com.elenabalan.dbtest.dao;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PostgresTestWriteDao implements TestWriteDao{

    private String connectionUrl = "jdbc:postgresql://192.168.99.100:32768/test";
    private String userName = "postgres";
    private String password = "postgres";

    private Connection connection;
    private String tableName = "speedtest" + new Random().nextInt();

    private void putFile(Path path) {

    }

    @Override
    public void putFiles(List<File> files) throws SQLException, IOException {

        String createTable = "CREATE TABLE " + tableName + " (" +
                "file bytea" +
                ")";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(createTable);
        List<byte[]> data = new LinkedList<>();
        int i = 0;
        for (File file : files) {
            data.add(FileUtils.readFileToByteArray(file));
        }
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO "+ tableName + " (file) VALUES (?)");
        for (byte[] dataFile : data){
            pstmt.setBytes(1,dataFile);
            pstmt.executeUpdate();
        }
    }

    @Override
    public void clearDB() throws SQLException {
        Statement stmt;
        stmt = getConnection().createStatement();
        String dropTable = "DROP TABLE " + tableName;
        stmt.executeUpdate(dropTable);
    }

    public Connection getConnection() throws SQLException {
        if (connection != null)
            return connection;
        return connection = DriverManager.getConnection(connectionUrl,userName,password);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
