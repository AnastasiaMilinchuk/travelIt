package com.travelit.secure.controller;

import com.travelit.secure.entity.Place;
import com.travelit.secure.service.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            place.setCreatorEmail(((UserDetails) principal).getUsername());
            model.addAttribute("place", place);
        }
        return "places";
    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ModelAndView addPhoto( @RequestParam("file") MultipartFile image, BindingResult result, WebRequest request, Errors errors){
//
//    }


    @RequestMapping(method = RequestMethod.POST, headers=("content-type=multipart/*"))
    public ModelAndView addPlace(@ModelAttribute("place") Place place,
                                 @RequestParam("file") MultipartHttpServletRequest image,
                                 BindingResult result, WebRequest request, Errors errors){
        System.out.println("add place method");
        if(!result.hasErrors()){
            place.setDateOfCreation(new Date());
            service.save(place);
            System.out.println(" save place");
//            if (!file.isEmpty()) {
//                try {
//                    byte[] bytes = file.getBytes();
//                    BufferedOutputStream stream =
//                            new BufferedOutputStream(new FileOutputStream(new File(place.getName())));
//                    stream.write(bytes);
//                    stream.close();
//                    System.out.println("You successfully uploaded " +place.getName() + "!");
//                } catch (Exception e) {
//                    System.out.println("You failed to upload " +place.getName()+ " => " + e.getMessage());
//                }
//            }

//
//            if (!image.isEmpty()) {
//                System.out.println("check image");
//                try {
//                    validateImage(image);
//                    System.out.println("validate image");
//
//                } catch (RuntimeException re) {
//                    result.reject(re.getMessage());
//                    System.out.println("error image");
//                }
//
//                try {
//                    saveImage(place.getName() + ".jpg", image);
//                    System.out.println("save image");
//                } catch (IOException e) {
//                    System.out.println("reject image");
//                    result.reject(e.getMessage());
//                }
            //}

            return new ModelAndView("places","successfull", place);
        }
        else {
            return new ModelAndView("places", "error", place);
        }
    }

//    @RequestMapping( method=RequestMethod.POST)
//    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
//                                                 @RequestParam("file") MultipartFile file){
//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(name)));
//                stream.write(bytes);
//                stream.close();
//                return "You successfully uploaded " + name + "!";
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        } else {
//            return "You failed to upload " + name + " because the file was empty.";
//        }
//    }

    private void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    private void saveImage(String filename, MultipartFile image)
            throws RuntimeException, IOException {
        try {
            byte[] bytes = image.getBytes();
            File file = new File(filename);
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(file));
            stream.write(bytes);
            stream.close();
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the image has been stored.");
        } catch (IOException e) {
            throw e;
        }
    }

}
