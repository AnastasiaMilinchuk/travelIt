package com.travelit.secure.controller;

/**
 * Created by milinchuk on 4/4/15.
 */

import com.travelit.secure.entity.Place;
import com.travelit.secure.search.UserPlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/main")
public class MainPageController {
    @Autowired
    private UserPlaces userPlaces;

    public void setUserPlaces(UserPlaces userPlaces) {
        this.userPlaces = userPlaces;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(ModelMap model){
        if(SecurityContextHolder.getContext().getAuthentication().getName() != "anonymousUser"){
            model.addAttribute("places",
                    getNinePlaces(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername())
            );
        }
        return "main";

    }

    private List<Place> getNinePlaces(String userEmail){
        return userPlaces.getNinePlacesForUser(userEmail);
    }


}