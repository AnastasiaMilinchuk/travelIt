package com.travelit.secure.controller;

/**
 * Created by milinchuk on 4/4/15.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model){
        return "main";
    }

}