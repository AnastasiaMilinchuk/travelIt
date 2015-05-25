package com.travelit.secure.controller;

import com.travelit.secure.config.StaticData;
import com.travelit.secure.entity.Place;
import com.travelit.secure.search.UserPlaces;
import com.travelit.secure.validation.PlaceAboutValidator;
import com.travelit.secure.validation.ValidateMassage;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by milinchuk on 5/20/15.
 */
@Controller
@ComponentScan("com.travelit")
public class ShowPlaceController {


    private PlaceAboutValidator placeAboutValidator;
    private UserPlaces userPlaceService;

    @Autowired
    public void setPlaceAboutValidator(PlaceAboutValidator placeAboutValidator) {
        this.placeAboutValidator = placeAboutValidator;
    }

    @Autowired
    public void setUserPlaceService(UserPlaces userPlaceService) {
        this.userPlaceService = userPlaceService;
    }

    @RequestMapping( value = "/place", method = RequestMethod.GET)
    public String showPlace(@RequestParam Map<String,String> request, ModelMap model) {
        for(ValidateMassage m :placeAboutValidator.isValidData(SecurityContextHolder.getContext().getAuthentication(), request).getValidateMassages()){
            System.out.println(m.message);
        }
        if(placeAboutValidator.isValidData(SecurityContextHolder.getContext().getAuthentication(), request).isValid()){
            Place place = userPlaceService.getPlaceById(request.get("id"));
            if(place != null){
                String email = ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

                if( userPlaceService.isSubscribe(email, place.getId())){
                    model.addAttribute("action", "unsubscribe");
                }
                else {
                    model.addAttribute("action", "subscribe");
                }

                model.addAttribute("place", place);
                return "place";
            }
        }

       return "redirect:/main";

    }

    @RequestMapping( value = "/subscribe", method = RequestMethod.POST)
    public String subscribe(@ModelAttribute("place") Place place, BindingResult result, ModelMap model) throws IOException {

            if(placeAboutValidator.isValidAuthentication(SecurityContextHolder.getContext().getAuthentication()).isValid){
                place.setSubscribes(place.getSubscribes() + 1);
                userPlaceService.subscribePlace(((UserDetails)SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal()).getUsername(), place.getId().toString());
                model.addAttribute("place",place);
                model.addAttribute("action",  "unsubscribe");
                return "place";
            }
            else {
                return "redirect:/main";
            }
    }

    @RequestMapping( value = "/subscribe", method = RequestMethod.GET)
    public String subscribeGet(@ModelAttribute("place") Place place, BindingResult result, ModelMap model) throws IOException {
            return "redirect:/main";
    }


    @RequestMapping( value = "/unsubscribe", method = RequestMethod.POST)
    public String unsubscribe(@ModelAttribute("place") Place place, BindingResult result, ModelMap model) throws IOException {

        if(placeAboutValidator.isValidAuthentication(SecurityContextHolder.getContext().getAuthentication()).isValid){
            place.setSubscribes(place.getSubscribes() - 1);
            userPlaceService.unsubscribePlace(((UserDetails) SecurityContextHolder.
                    getContext().getAuthentication().getPrincipal()).getUsername(), place.getId().toString());

            model.addAttribute("place",place);
            model.addAttribute("action",  "subscribe");
            return "place";
        }

        return "redirect:/main";
    }

    @RequestMapping( value = "/unsubscribe", method = RequestMethod.GET)
    public String unsubscribeGet(@ModelAttribute("place") Place place, BindingResult result, ModelMap model) throws IOException {
        return "redirect:/main";
    }

}
