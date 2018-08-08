package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entity_random_file.Result;
import com.elenabalan.dbtest.service.DbTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/dbtest")

public class RestDbTestController implements DbTestController {

    @Autowired
    DbTestService dbTestService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public Duration testDatabase(TestParameters parameters) {
        return null;
    }
}
