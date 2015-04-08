package com.travelit.secure.controller;



import com.travelit.secure.entity.User;
import com.travelit.secure.service.TravelUserService;
import com.travelit.secure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by milinchuk on 4/5/15.
 */
@Controller
@ComponentScan("com.travelit")
@RequestMapping("/signup")
public class SignupController {

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(@Valid @ModelAttribute("user")User user,
                           BindingResult result,Model model){

        return "signup";
    }

}
