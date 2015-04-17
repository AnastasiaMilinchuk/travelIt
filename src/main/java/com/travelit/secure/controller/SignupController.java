package com.travelit.secure.controller;



import com.travelit.secure.entity.User;
import com.travelit.secure.service.TravelUserService;
import com.travelit.secure.service.UserService;
import org.apache.maven.artifact.repository.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @RequestMapping(method = RequestMethod.GET)
//    public String mainPage(WebRequest requestModel model){
//        User userDto = new User();
//        model.addAttribute("user", userDto);
//        System.out.println("Create User");
//        System.out.println("Signup");
//        return "signup";
//    }

    UserService service;
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        User userDto = new User();
        model.addAttribute("user", userDto);
        System.out.println("Create User");
        return "signup";
    }

    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid User account,
                                            BindingResult result, WebRequest request, Errors errors) {
        org.springframework.security.core.userdetails.User registered = null;

        System.out.println("Check User");
        if (!result.hasErrors()) {
            registered = createUserAccount(account, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message");
        }
        if (result.hasErrors()) {
            return new ModelAndView("signup", "user", account);

        }
        else {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(registered, new Object(),  registered.getAuthorities()));
            return new ModelAndView("main", "user", registered);
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
