package com.travelit.secure.controller;

import com.travelit.secure.entity.City;
import com.travelit.secure.entity.Response;
import com.travelit.secure.search.UserPrefer;
import com.travelit.secure.service.services.PlaceService;
import com.travelit.secure.validation.CommonValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class RoutesController {
    @Qualifier("commonValidation")
    @Autowired
    private CommonValidation commonValidation;

    @Qualifier("userPrefer")
    @Autowired
    private UserPrefer userPrefer;
//    @Autowired
//    private PlaceService placeService;

//    @RequestMapping(method = RequestMethod.POST)
//    public String profilePage(ModelMap model){
//        if(commonValidation.isAuthorize().isValid){
//            System.out.println(userPrefer.getPlacePrefersByLocation("Kiev").size());
//            model.addAttribute("places", userPrefer.getPlacePrefersByLocation("Kiev"));
//            return "routes";
//
//        }
//        return "redirect:login";
//    }

    @RequestMapping(value = "/routes", method = RequestMethod.GET)
    public String findPlaceStartGET(Model model){
        if(commonValidation.isAuthorize().isValid){
           // model.addAttribute("response",  new Response(userPrefer.getPlacePrefersByLocation("Kiev")));
            Map<String, String> cities = new LinkedHashMap<>();
//            cities.put("Kiev", "Kiev");
//            cities.put("Odessa", "Odessa");
//            cities.put("Lviv", "Lviv");
//            model.addAttribute("cities", cities);
            model.addAttribute("city", new City());
            return "routes";
        }

        return "redirect:login";
    }

    @RequestMapping(value = "/routes", method = RequestMethod.POST)
    public ModelAndView getRoutes(@ModelAttribute("city") City city){
        if(commonValidation.isAuthorize().isValid){
            System.out.println(city);
            if (city != null && city.getCityName() != ""){
                System.out.println("get routes");
                Response response =  new Response(userPrefer.getPlacePrefersByLocation(city.getCityName()));
                System.out.println(response.getCoordinates().size());
                return new ModelAndView("routes", "response", response);
            }
        }

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/routes/get", method = RequestMethod.GET)
    public @ResponseBody Response get(@RequestParam("city") String city, Model model){
        System.out.println("click kokoko");
            if(commonValidation.isAuthorize().isValid){
                System.out.println(city);
                if (city != null && city != ""){
                    System.out.println("get routes");
                    Response response =  new Response(userPrefer.getPlacePrefersByLocation(city));
                    System.out.println(response.getCoordinates().size());
                    return response;
                }
            }
        return new Response();
    }
}

