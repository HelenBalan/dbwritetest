package com.elenabalan.dbtest.Controller;

import com.elenabalan.dbtest.EntityRandomFile.Result;
import com.elenabalan.dbtest.Service.DbTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
