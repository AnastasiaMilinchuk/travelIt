package com.travelit.secure.controller;

import com.travelit.secure.validation.CommonValidation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    CommonValidation commonValidation;

    public void setCommonValidation(CommonValidation commonValidation) {
        this.commonValidation = commonValidation;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String profilePage(Model model){
        if(commonValidation.isAuthorize().isValid){
            return "routes";
        }
        return "login";
    }
}

