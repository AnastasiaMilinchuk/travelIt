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
 * Created by milinchuk on 5/21/15.
 */
@Controller
@RequestMapping("/routes")
public class RoutesController {
    @RequestMapping(method = RequestMethod.POST)
    public String profilePage(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();
            List<GrantedAuthority> roles = (List<GrantedAuthority>)((UserDetails)principal).getAuthorities();
        }
        return "routes";
    }

}