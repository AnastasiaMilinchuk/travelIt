package com.travelit.secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bubble on 24.05.15.
 */

@Controller
@RequestMapping("/routes")
public class RoutesController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        return "routes";
    }
}
