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
    <div class="login">
        <div>
            <form action="${loginUrl}" method="post">

                <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
                <input style="display:none" type="text" name="fakeusernameremembered"/>
                <input style="display:none" type="password" name="fakepasswordremembered"/>

                <input type="text" name = "j_username" placeholder = "E-mail" id = "email" autocomplete="off" />
                <p><input type = "password" name = "j_password" placeholder = "Password" id = "password" autocomplete="off"/></p>
                <p><input type = "submit" value = "Log In" id = "submit" /><div id = "error">Such user doesn't exist. Try again</div> </p>
            </form>
            <%--<div class="add_link">--%>

            <%--<div> Not have account yet?</div>--%>
            <%--<div>Please--%>
            <%--<a href="signup">Sign Up</a> or via social network:--%>
            <%--</div>--%>
            <%--<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>--%>
            <%--</div>--%>
            <div>
                <div class="no-have-account">  Not have account yet? <a class="no-have-account" href="signup">Sign Up</a>
                </div>


                <%--<div>Please--%>
                <%--<a href="signup">Sign Up</a> or via social network:--%>
                <%--</div>--%>
                <%--<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>--%>
            </div>
        </div>
    </div>
</div>
<div id = "background"></div>

</body>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
<H1>
    Sign Up
</H1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <br>
    <tr>
        <td><label>
            First Name
        </label>
        </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <br>
    <tr>
        <td>
            <label>
                Last Name
        </label>
        </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <br>
    <tr>
        <td><label>E-mail
        </label>
        </td>
        <td><form:input path="email" value="" /></td>
        <%--<form:errors path="email" element="div" />--%>
    </tr>
    <br>
    <tr>
        <td><label>Password
        </label>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <br>
    <tr>
        <td><label>Confirm Password
        </label>
        </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    <br>
    <button type="submit">Submit
    </button>
</form:form>
<br>
<a href="<c:url value="login.jsp" />">

</a>
</body>
</html>