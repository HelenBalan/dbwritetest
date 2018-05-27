package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entity_random_file.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dbtest")

public class RestDbTestController implements DbTestController {

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public void createFiles(@RequestBody int count, @RequestBody int maxSize) {
        /* not implemented */
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public void setDbParametres(String url, String login, char[] password) {
        /* not implemented */
    }

    @RequestMapping(value = "/load")
    @Override
    public void loadData() {
        /* not implemented */
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public Result getResult() {
        return null;
    }
}
