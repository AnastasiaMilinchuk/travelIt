package com.travelit.secure.validation;

import com.travelit.secure.validation.annotations.ValidPlace;

import java.util.List;
import java.util.Map;

/**
 * Created by milinchuk on 5/15/15.
 */
public class ValidateMassage {
    public final boolean isValid;
    public final String message;

    public ValidateMassage(boolean isValid, String message){
       this.message = message;
       this.isValid = isValid;
    }
}
