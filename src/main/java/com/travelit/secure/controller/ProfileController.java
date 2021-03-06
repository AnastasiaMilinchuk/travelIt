package com.travelit.secure.controller;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.UserService;
import com.travelit.secure.validation.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created by milinchuk on 4/4/15.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Inject
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(ModelMap model){
        String email = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("similarUsers", userService.getSimilarUsersByPreferences(email, 20));
        return "profile";
    }

}
