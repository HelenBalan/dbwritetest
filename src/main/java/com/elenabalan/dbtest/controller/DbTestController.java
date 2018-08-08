package com.elenabalan.dbtest.controller;

import com.elenabalan.dbtest.entity_random_file.Result;
import java.time.Duration;

public interface DbTestController {

    Duration testDatabase(TestParameters parameters);
}
