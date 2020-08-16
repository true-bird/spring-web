package org.truebird.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/doA")
    public void doA(){
        System.out.println("DDD");
        // test
    }
}
