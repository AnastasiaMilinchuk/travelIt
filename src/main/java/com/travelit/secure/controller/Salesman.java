package com.travelit.secure.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by milinchuk on 6/10/15.
 */
@Controller
@RequestMapping("/salesman")
public class Salesman {
    @RequestMapping(method = RequestMethod.GET)
    public String salesman(Model model){
        return "salesman";
    }

}