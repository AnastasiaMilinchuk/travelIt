package com.travelit.secure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile-about")
public class ProfileAboutController {
    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        return "profile-about";
    }
}
