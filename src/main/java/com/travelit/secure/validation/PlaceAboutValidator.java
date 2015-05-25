package com.travelit.secure.validation;

import com.travelit.secure.service.services.PlaceService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by milinchuk on 5/21/15.
 */
@Service
@Configuration
public class PlaceAboutValidator {

    public ValidateMessagesList isValidData(Authentication auth, Map<String,String> request){
        List<ValidateMassage> validateMassages = new LinkedList<>();
        validateMassages.add(isValidAuthentication(auth));
        validateMassages.add(isExistID(request));

        return new ValidateMessagesList(validateMassages, isValidAuthentication(auth).isValid &&
                isExistID(request).isValid &&
                isValidID(request.get("id")).isValid);
    }

    public ValidateMassage isValidAuthentication(Authentication auth){
        return new ValidateMassage(
                auth.getName() != "anonymousUser" && auth.getName() != "null" && auth.getName() !="",
                "Is authenticate"
        );
    }

    public  ValidateMassage isExistID(Map<String,String> request){
        return new ValidateMassage(request.get("id") != null, "Exist id in GET request");
    }

    public ValidateMassage isValidID(String id){
        try{
           ObjectId o = new ObjectId(id);
            return new ValidateMassage(true, "Valid id argument");
        }
        catch (IllegalArgumentException e){
            return new ValidateMassage(false, e.getMessage());
        }
    }


}

