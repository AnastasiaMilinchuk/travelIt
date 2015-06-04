package com.travelit.secure.controller;

import com.travelit.secure.entity.FileUpload;
import com.travelit.secure.entity.Place;
import com.travelit.secure.entity.PlaceData;
import com.travelit.secure.search.UserPlaces;
import com.travelit.secure.service.services.PlaceService;
import com.travelit.secure.validation.CommonValidation;
import com.travelit.secure.validation.SavePlaceValidator;
import com.travelit.secure.validation.ValidateMassage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Controller
@ComponentScan("com.travelit")
public class PlacesController{
    @Autowired
    private UserPlaces userPlaces;
    @Autowired
    private  PlaceService placeService;
    @Autowired
    private CommonValidation commonValidation;

    private SavePlaceValidator validator;
    private MultipartFile file;


    public void setService( UserPlaces service) {
        this.userPlaces = service;
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET )
    public String start(ModelMap model){
        if(commonValidation.isAuthorize().isValid){
            System.out.println("koko start method ");
            model.addAttribute("subscribePlaces", userPlaces.getSubscribePlaces(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
            model.addAttribute("addedPlaces", userPlaces.getAddedByUserPlaces(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
            model.addAttribute("file", new FileUpload());
            model.addAttribute("place", new Place());
            return "places";
        }
        return "redirect:login";
    }

    @RequestMapping(value="/places", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("place") Place place,
                                 BindingResult result,ModelMap model , Errors errors ) throws IOException {
        if(!result.hasErrors() && file != null){
            System.out.println("koko no errs");
            String msg = save(new FileUpload().getFile(), place);
            return new ModelAndView("places", "msg", place);
        }
        else {
            return new ModelAndView("places", "error", place);
        }
    }

    private String save(MultipartFile file, Place place) throws IOException {
       System.out.println("saving");
        ValidateMassage imgMessage = validator.validateImage(file);
        if(imgMessage.isValid){
            // Save image
            String imagePath = saveImage(file.getOriginalFilename());

            // Fill place's data
            fillPlace(imagePath, place);

            // save Place
            System.out.println("save place");
        }
        placeService.save(place);
        return "";
    }

    private void fillPlace(String imagePath, Place place){
        place.setCreatorEmail(((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        place.setDateOfCreation(new Date());
        place.setPhoto(imagePath);
        // set Coordinates
    }


    private String saveImage(String filename)
            throws RuntimeException, IOException {
        try {
            byte[] bytes = file.getBytes();
            File file = new File(filename);
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(file));
            stream.write(bytes);
            stream.close();
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the image has been stored.");
            return file.toString();
        } catch (IOException e) {
            throw e;
        }
    }


//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String upload(@ModelAttribute("file") FileUpload file) throws IOException {
//        System.out.println("upload " + file.toString());
//        ValidateMassage message = validator.validateImage(file.getFile());
//        if (message.isValid){
//            this.file = file.getFile();
//            saveImage(file.getFile().getOriginalFilename());
//        }
//        return message.message;
//    }

}
