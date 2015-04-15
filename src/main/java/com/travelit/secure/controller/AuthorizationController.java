package com.travelit.secure.controller;

/**
 * Created by milinchuk on 4/2/15.
 */
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/login")
public class AuthorizationController {
    @RequestMapping(method = RequestMethod.POST)
    public String profilePage(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();
            List<GrantedAuthority> roles = (List<GrantedAuthority>)((UserDetails)principal).getAuthorities();
        }
        return "main";
    }

}