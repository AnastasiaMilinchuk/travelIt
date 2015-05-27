package com.travelit.secure.validation;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by milinchuk on 5/21/15.
 */
@Service
@Configuration
public class CommonValidation {
    public ValidateMassage isAuthorize(){
        return new ValidateMassage(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"), "Authenticate user");
    }
}
