package com.travelit.secure.controller;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.UserService;
import com.travelit.secure.validation.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile-about")
public class ProfileAboutController {
    @Autowired
    private UserService userService;

    @Qualifier("commonValidation")
    @Autowired
    private CommonValidation commonValidation;

    public void setCommonValidation( CommonValidation commonValidation) {
        this.commonValidation = commonValidation;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        if(commonValidation.isAuthorize(SecurityContextHolder.getContext().getAuthentication()).isValid){
            model.addAttribute("user", getUserDetails(((UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal())
                    .getUsername()));
            return "profile-about";
        }
        else{
            return "redirect:/login";
        }

    }

    public User getUserDetails(String userEmail){
        return userService.getByEmail(userEmail);
    }
}
