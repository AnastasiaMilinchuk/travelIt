package com.travelit.secure.entity;

/**
 * Created by milinchuk on 5/26/15.
 */
public class Password {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    public Password() {

    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isMatchesNewPassword(){
        return newPassword.equals(confirmPassword);
    }

    public boolean isMatchesOldPassword(String oldPassword){
        return currentPassword.equals(oldPassword);
    }

}
