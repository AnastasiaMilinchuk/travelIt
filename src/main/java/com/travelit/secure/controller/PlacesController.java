package com.travelit.secure.controller;

import com.travelit.secure.entity.FileUpload;
import com.travelit.secure.entity.Place;
import com.travelit.secure.entity.PlaceData;
import com.travelit.secure.service.services.PlaceService;
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

    private PlaceService service;
    private SavePlaceValidator validator;
    private MultipartFile file;

    @Autowired
    public void setService(@Qualifier("placeMongoService") PlaceService service) {
        this.service = service;
    }

    public void setValidator(SavePlaceValidator validator) {
        this.validator = validator;
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET )
    public String start(ModelMap model){
        System.out.println("koko start method ");
        model.addAttribute("places", new PlaceData());
        model.addAttribute("file", new FileUpload());
        return "places";
    }

    @RequestMapping(value="/places", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("places") PlaceData places,
                                 BindingResult result,ModelMap model , Errors errors ) throws IOException {
        System.out.println(model.get("file"));
        System.out.println("click PlaceData "+ places.getOlolo());
        System.out.println("koko getPlace " + places.getPlace());
        System.out.println("koko submit " + places.getPlace().getName());
        System.out.println("click sdgsdg " + places.getPlace().getAddress());
        System.out.println("koko file " + places.getImage());


        System.out.println("add place method");

        if(!result.hasErrors() && file != null){
            System.out.println("koko no errs");
            String msg = save(places.getImage(), places.getPlace());
            return new ModelAndView("places", "msg", places);
        }
        else {
            return new ModelAndView("places", "error", places);
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
            service.save(place);
        }
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
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    private String upload(@ModelAttribute("file") FileUpload file) throws IOException {
        System.out.println("upload " + file.toString());
        ValidateMassage message = validator.validateImage(file.getFile());
        if (message.isValid){
            this.file = file.getFile();
            saveImage(file.getFile().getOriginalFilename());
        }
        return message.message;
    }

}
