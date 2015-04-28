/**
 * Created by bubble on 09.04.15.
 */

var validateEmail = function (email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};

var validatePassword = function (password){
    if (password.length >= 2){
         return true;
    }
    else{
        return false;
    }
};

var addError = function (field, message, submit) {
    field.placeholder = message;
    field.style.backgroundImage = "url(https://cdn1.iconfinder.com/data/icons/smallicons-controls/32/614338-.svg-512.png)";
    field.style.backgroundSize = "25px 25px";
    field.style.backgroundRepeat = "no-repeat";
    field.style.backgroundPosition = " 25px 3px";
    submit.disabled = true;
};

var main = function() {
    var email = document.getElementById("email");
    var  password = document.getElementById("password");
    var submit = document.getElementById("submit");

    email.onblur = function (){
        var message = "E-mail";
        if (!validateEmail(email.value)){
            if (email.value === "")
                message = "Please, input your e-mail";
            addError(email, message, submit);
        } else {
            email.style.background = "none";
            submit.disabled = false;
        }

    };

    password.onblur = function() {
        if (!validatePassword(password.value)) {
            var message = "Please, input correct password";
            addError(password, message, submit);
        } else {
            password.style.background = "none";
            submit.disabled = false;
        }
    };
};

$(document).ready(main);

//$(document).ready(function(){
//
//    $("#password").onblur(function(){
//        var password = $("password").val();
//        var email = $("email").val();
//
//        if(validateEmail(email) && validatePassword(password)){
//            $("#background").css({"-webkit-filter" : "grayscale(0%)"});
//        }
//        else{
//            $("#background").css({"-webkit-filter" : "grayscale(100%)"})
//        }
//
//    });

    //$("#email").onblur(function(){
    //    var password = $("password").val();
    //    var email = $("email").val();
    //
    //    if(validateEmail(email) && validatePassword(password)){
    //        $("background").css({"-webkit-filter" : "grayscale(0%)"});
    //        alert("koko1");
    //    }
    //    else{
    //        alert("koko2");
    //        $("background").css({"-webkit-filter" : "grayscale(100%)"})
    //    }
    //
    //})


//
//});
