package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entity_random_file.Result;

public interface DbTestController {

    void createFiles(int count, int maxSize);

    void setDbParametres(String url, String login, char[] password);

    void loadData();

    Result getResult();

}
