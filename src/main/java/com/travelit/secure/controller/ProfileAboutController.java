package com.travelit.secure.controller;

import com.travelit.secure.entity.Password;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
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


    @RequestMapping(value = "/profile-about", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        if(commonValidation.isAuthorize().isValid){
            System.out.println(commonValidation.isAuthorize().isValid);
            model.addAttribute("user", getUserDetails(((UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal())
                    .getUsername()));
            model.addAttribute("password", new Password());
            return "profile-about";
        }

        return "redirect:/login";
    }

    public User getUserDetails(String userEmail){
        return userService.getByEmail(userEmail);
    }

    @RequestMapping(value = "/save-details", method = RequestMethod.POST)
    public String changeUserDetails(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, ModelMap model){
        if(commonValidation.isAuthorize().isValid){
            User principal = userService.getByEmail(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
            userService.changeFirstName(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(), firstName);
            userService.changeLastName(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(), lastName);

            principal.setFirstName(firstName);
            principal.setLastName(lastName);

            model.addAttribute("password", new Password());
            model.addAttribute("user", principal);

            return "redirect:/profile-about";

        }

        return "redirect:/login";
    }

    @RequestMapping(value = "/save-password", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("password") Password password){
        if(commonValidation.isAuthorize().isValid){

        }

        return "redirect:/login";
    }
}