package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entityRandomFile.Result;

public interface DbTestController {

    void createFiles(int count, int maxSize);

    void setDbParametres(String url, String login, char[] password);

    void loadData();

    Result getResult();

}
