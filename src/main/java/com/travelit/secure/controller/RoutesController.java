package com.travelit.secure.controller;

import com.travelit.secure.service.services.PlaceService;
import com.travelit.secure.validation.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    @Autowired
    CommonValidation commonValidation;

    @Autowired
    PlaceService placeService;

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    public void setCommonValidation(CommonValidation commonValidation) {
        this.commonValidation = commonValidation;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String profilePage(ModelMap model){
        if(commonValidation.isAuthorize().isValid){
            System.out.println(placeService.getPlaces(6).size());
            model.addAttribute("places", placeService.getPlaces(6));
            return "routes";
        }
        return "redirect:login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String findPlaceStartGET(Model model){
        if(commonValidation.isAuthorize().isValid){
            model.addAttribute("places", placeService.getPlaces(6));
            return "routes";
        }
        return "redirect:login";
    }
}

