/**
 * Created by bubble on 28.04.15.
 */

var validateEmail = function (email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};

var notEmptyField = function (field){
    if (field.length >= 2){
        return true;
    }
    else{
        return false;
    }
}

var addError = function (field, message, submit) {
    field.value = "";
    field.placeholder = message;
    field.style.backgroundImage = "url(https://cdn1.iconfinder.com/data/icons/smallicons-controls/32/614338-.svg-512.png)";
    field.style.backgroundSize = "25px 25px";
    field.style.backgroundRepeat = "no-repeat";
    field.style.backgroundPosition = " 25px 3px";
    submit.disabled = true;
};

var takeAwayError = function(field, submit) {
    field.style.background = "none";
    submit.disabled = false;
};

var validate = function(field, submit) {
    if (!notEmptyField(field.value))
        addError(field, "Fill data, please", submit);
    else takeAwayError(field, submit);
};


var main = function() {
    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var submitPassword = document.getElementById("submitPassword");
    var submit = document.getElementById("submit");

    firstName.onblur = function() {
        validate(firstName, submit);
    };
    lastName.onblur = function() {
        validate(lastName, submit);
    };
    email.onblur = function () {
        if (!validateEmail(email.value)) addError(email, "Input valid email", submit);
        else takeAwayError(email);
    };
    //    validateEmail(email); //!
    password.onblur = function() {
        validate(password, submit);
    };
    submitPassword.onblur = function() {
       // validate(submitPassword, submit);
        if (password.value != submitPassword.value) addError(submitPassword, "Password doesn't match", submit);
        else takeAwayError(submitPassword, submit);
    };
};

$(document).ready(main);