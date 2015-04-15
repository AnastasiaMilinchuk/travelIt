package com.travelit.secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by milinchuk on 4/4/15.
 */
@Controller
@RequestMapping("/places")
public class PlacesController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model){
        return "places";
    }
}
