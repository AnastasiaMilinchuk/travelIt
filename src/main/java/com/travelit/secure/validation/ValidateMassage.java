package com.travelit.secure.validation;

import com.travelit.secure.validation.annotations.ValidPlace;

/**
 * Created by milinchuk on 5/15/15.
 */
public class ValidateMassage {
    public final boolean isValid;
    public final String message;

    public ValidateMassage(boolean isValid, String message){
        this.isValid = isValid;
        this.message = message;
    }
}
