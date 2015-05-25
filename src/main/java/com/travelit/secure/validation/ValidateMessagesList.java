package com.travelit.secure.validation;

import java.util.List;

/**
 * Created by milinchuk on 5/21/15.
 */
public class ValidateMessagesList {
    private List<ValidateMassage> validateMassages;
    private boolean isValid;

    public List<ValidateMassage> getValidateMassages() {
        return validateMassages;
    }

    public boolean isValid() {
        return isValid;
    }

    public ValidateMessagesList(List<ValidateMassage> validateMassages, boolean isValid) {
        this.validateMassages = validateMassages;
        this.isValid = isValid;
    }
}
