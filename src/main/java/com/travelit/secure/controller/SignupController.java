package com.travelit.secure.controller;

import com.travelit.secure.entity.Preference;
import com.travelit.secure.entity.User;
import com.travelit.secure.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public String showRegistrationForm(WebRequest request, Model model) throws Exception {
        User userDto = new User();
        List<Preference> p = new ArrayList<>();
        p.add(new Preference("films", new ArrayList(){{
            add("kokoko");
        }}));

        userDto.setEmail("kfdkfls@gmail.com"); 
        userDto.setPassword("koko");
        userDto.setPreferences(p);
        service.registerNewUserAccount(userDto);
        model.addAttribute("user", userDto);
        System.out.println("Create User");
        return "signup";
    }

    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid User account,
                                            BindingResult result, WebRequest request, Errors errors) {
        org.springframework.security.core.userdetails.User registered = null;

        Object o = new Object();
        account.setPassword(new ShaPasswordEncoder().encodePassword(account.getPassword(), o));
        account.setMatchingPassword(new ShaPasswordEncoder().encodePassword(account.getMatchingPassword(), o));
        System.out.println("Check User");
        if (!result.hasErrors()) {
            registered = createUserAccount(account, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message");
        }
        if (result.hasErrors()) {
            account.setPassword("");
            account.setMatchingPassword("");
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
