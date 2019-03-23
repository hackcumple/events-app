package com.hackcumple.eventsapp.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api2/presentation2")
public class NewController {

    @RequestMapping(value = "getDateAndTime")
    public String getDateAndTime() {
        System.out.println();


        return "static/index";
    }
}
