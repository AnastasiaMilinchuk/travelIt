<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring Security</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src = "<c:url value="/pages/js/auth_ajax.js" />" ></script>
    <link href="<c:url value="/pages/css/auth.css" />" rel="stylesheet">
</head>

<body>
    <div class = "logo">
        <h1>TravelIt.com</h1>
        <h2>Live. Love. Travel </h2>
    </div>
    <div class = "input_data"><c:url value="/j_spring_security_check" var="loginUrl" />
        <form action="${loginUrl}" method="post">
            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
            <input style="display:none" type="text" name="fakeusernameremembered"/>
            <input style="display:none" type="password" name="fakepasswordremembered"/>

            <input type="text" name = "j_username" placeholder = "E-mail" id = "email" autocomplete="off" />
            <p><input type = "password" name = "j_password" placeholder = "Password" id = "password" autocomplete="off"/></p>
            <p><input type = "submit" value = "Log In" id = "submit" /><div id = "error">Such user doesn't exist. Try again</div> </p>
        </form>
        <div class="add_link">
            <a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>
            <a href="register.html">Don't Have an Account?</a>
        </div>
    </div>
    <div id = "background"></div>


<%--<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="admin">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
<<<<<<< HEAD
</div>--%>
=======

    <div>
        <p>No account yet? Please <a href="signup">Sign Up</a></p>
    </div>
</div>
>>>>>>> 78b40245292fffc4914f31d0494c2b8aa31d513f

</body>
</html>
