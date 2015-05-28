package com.travelit.secure.controller;

import com.travelit.secure.validation.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/find-places")
//@RequestMapping("/login")
public class FindPlacesController {
    CommonValidation commonValidation;

    @Autowired
    public void setCommonValidation(@Qualifier("commonValidation") CommonValidation commonValidation) {
        this.commonValidation = commonValidation;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String findPlaceStart(Model model){
        if(commonValidation.isAuthorize().isValid){
             return "find-places";
        }
        return "redirect:login";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String findPlaceStartGET(Model model){
        if(commonValidation.isAuthorize().isValid){
            return "find-places";
        }
        return "redirect:login";
    }

}
