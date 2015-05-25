package com.travelit.secure.validation;

import com.travelit.secure.entity.Place;
import com.travelit.secure.validation.annotations.ValidPlace;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by milinchuk on 4/27/15.
 */
public class PlaceValidator implements ConstraintValidator<ValidPlace, Place> {

    @Override
    public void initialize(ValidPlace validPlace) {
    }

    @Override
    public boolean isValid(Place place, ConstraintValidatorContext context){
        return isTagsValid(place.getTags()) &&
                isAddressValid(place.getAddress()) &&
                isNameValid(place.getName());
    }


    private boolean isTagsValid(List<String> tags){
        System.out.println(tags);
        if(tags!= null && tags.size() != 0){
            return true;
        }
        else return false;
    }

    private boolean isAddressValid(String address) {
        System.out.println(address);
        if(address != null && address != ""){
            return true;
        }
        else return false;
    }

    private boolean isNameValid(String name) {
        System.out.println(name);
        if(name != null && name != ""){
            return true;
        }
        else return false;
    }
}
