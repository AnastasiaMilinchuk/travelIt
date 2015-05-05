package com.travelit.secure.controller;

import com.travelit.secure.entity.Place;
import com.travelit.secure.service.services.PlaceService;
import com.travelit.secure.service.services.UserService;
import com.travelit.secure.validation.annotations.ValidPlace;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by milinchuk on 4/4/15.
 */
@Controller
@RequestMapping("/places")
public class PlacesController {

    PlaceService service;
    @Autowired
    public void setService(PlaceService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model){
        Place place = new Place();
        model.addAttribute("place", place);
        return "places";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addPlace(@ModelAttribute("place") Place place,
                           BindingResult result, WebRequest request, Errors errors){
        if(!result.hasErrors()){
            service.save(place);
            return new ModelAndView("added", "place", place);
        }
        else {
            return new ModelAndView("places", "place", place);
        }
    }

}
