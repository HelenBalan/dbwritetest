package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entityRandomFile.Result;
import com.elenabalan.dbtest.service.DbTestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbtest")

public class RestDbTestController implements DbTestController {

    private DbTestService dbTestService;

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public void createFiles(@RequestBody int count, @RequestBody int maxSize) {

    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public void setDbParametres(String url, String login, char[] password) {

    }

    @RequestMapping(value = "/load")
    @Override
    public void loadData() {

    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public Result getResult() {
        return null;
    }
}
