package com.travelit.secure.validation;
import com.travelit.secure.entity.FileUpload;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class SavePlaceValidator implements Validator{

    @Override
    public boolean supports(Class clazz) {
        //just validate the FileUpload instances
        return FileUpload.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FileUpload file = (FileUpload)target;

        if(file.getFile().getSize()==0){
            errors.rejectValue("file", "required.fileUpload");
        }
    }
    public ValidateMassage validatePlaceData(){
        throw new UnsupportedOperationException();
    }

    public ValidateMassage validateImage(MultipartFile file){
        if(file != null && !file.isEmpty()){
            if(isFileImage(file)){;
                return new ValidateMassage(true, "Upload successful");
            }
            else {
                return new ValidateMassage(false, "Choose image");
            }
        }
        return new ValidateMassage(false, "Not image selected!");
    }

    private boolean isFileImage(MultipartFile image) {
        return (!image.getContentType().equals("image/jpeg"));
    }
}