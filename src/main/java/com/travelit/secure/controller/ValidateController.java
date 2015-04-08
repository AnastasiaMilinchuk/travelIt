package com.travelit.secure.controller;

import com.travelit.secure.entity.User;
import com.travelit.secure.service.TravelUserService;
import com.travelit.secure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
 * Created by milinchuk on 4/7/15.
 */
@Controller
@ComponentScan("com.travelit")
@RequestMapping("/user/registration")
public class ValidateController {
    UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }


    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User userDto = new User();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid User account,
                                            BindingResult result, WebRequest request, Errors errors) {
        org.springframework.security.core.userdetails.User registered =
                createUserAccount(account, result);

        if (!result.hasErrors()) {
            registered = createUserAccount(account, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", account);
        }
        else {
            return new ModelAndView("successRegister", "user", account);
        }
    }
    private org.springframework.security.core.userdetails.User createUserAccount(User accountDto, BindingResult result) {
        org.springframework.security.core.userdetails.User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
//        } catch (EmailExistsException e) {
//            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registered;
    }
}
