package com.elenabalan.dbtest.Controller;

import com.elenabalan.dbtest.EntityRandomFile.Result;

public interface DbTestController {

    public void createFiles(int count, int maxSize);

    public void setDbParametres(String url, String login, char[] password);

    public void loadData();

    public Result getResult();

}
