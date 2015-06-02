package com.travelit.secure.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/routes")
public class RoutesController {
    @Autowired
    private CommonValidation commonValidation;
    @Autowired
    private UserPrefer userPrefer;
//    @Autowired
//    private PlaceService placeService;


    public void setCommonValidation(CommonValidation commonValidation) {
        this.commonValidation = commonValidation;
    }

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

    @RequestMapping(method = RequestMethod.GET)
    public String findPlaceStartGET(Model model){
        if(commonValidation.isAuthorize().isValid){
            //model.addAttribute("response",  new Response(userPrefer.getPlacePrefersByLocation("Kiev")));
            return "routes";
        }
        return "redirect:login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getRoutes(String city){
        if(commonValidation.isAuthorize().isValid){
            System.out.println(city);
            if (city != null && city != ""){
                System.out.println("get routes");
                Response response =  new Response(userPrefer.getPlacePrefersByLocation(city));
                System.out.println(response.getCoordinates().size());
                return new ModelAndView("routes", "response", response);
            }
        }

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "routes/get", method = RequestMethod.GET)
    public @ResponseBody Response get(String city){
        if(commonValidation.isAuthorize().isValid){
            if (city != null && city != ""){
                System.out.println("get routes");
                return new Response(userPrefer.getPlacePrefersByLocation(city));

            }
            else{
                return new Response(userPrefer.getPlacePrefersByLocation(city));
            }

        }
        return new Response();
    }
}

