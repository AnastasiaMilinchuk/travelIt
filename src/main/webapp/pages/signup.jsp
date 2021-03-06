<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

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
    <script type="text/javascript" src = "<c:url value="/pages/js/registration_validate.js" />" ></script>
    <link href="<c:url value="/pages/css/authorize.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/footer.css" />" rel="stylesheet">
</head>

<body>
<header>
</header>

<section>
    <div class = "article">
        <h1>Sign Up</h1>
    </div>
    <div class="container">

        <div class="logo">
            <a href="<c:url value="/" />">
                <img src="/travelit/pages/images/travelItLogo2.png"/>
            </a>
        </div>

        <div class = "input_data"><c:url value="/j_spring_security_check" var="loginUrl" />
            <div class="login">
                <div>
                    <form:form modelAttribute="user" method="POST" enctype="utf8">

                        <form:input path="firstName"  placeholder="First Name" id = "firstName" autocomplete="off"/>
                        <form:errors path="firstName" element="div"/>

                        <form:input path="lastName" placeholder="Last Name" id = "lastName" autocomplete="off"/>
                        <form:errors path="lastName" element="div" />

                        <form:input path="email" placeholder="E-mail" id="email" value="" autocomplete="off"/>
                        <%--<form:errors path="email" element="div" />--%>
                        <form:input path="password" value="" placeholder="Password" id="password" type="password" autocomplete="off"/></td>
                        <form:errors path="password" element="div" />

                        <form:input path="matchingPassword" value="" id="submitPassword" placeholder="Confirm Passsword" type="password" autocomplete="off"/></td>
                        <form:errors element="div" />

                        <p> <input type = "submit" value="Sign Up" id = "submit" />
                        </p>
                    </form:form>
                    <br>

                    <%--<form action="${loginUrl}" method="post">--%>

                    <%--<!-- fake fields are a workaround for chrome autofill getting the wrong fields -->--%>
                    <%--<input style="display:none" type="text" name="fakeusernameremembered"/>--%>
                    <%--<input style="display:none" type="password" name="fakepasswordremembered"/>--%>

                    <%--<input type="text" name = "j_username" placeholder = "E-mail" id = "email" autocomplete="off" />--%>
                    <%--<p><input type = "password" name = "j_password" placeholder = "Password" id = "password" autocomplete="off"/></p>--%>
                    <%--<p><input type = "submit" value = "Log In" id = "submit" /><div id = "error">Such user doesn't exist. Try again</div> </p>--%>
                    <%--</form>--%>
                    <%--<div class="add_link">--%>

                    <%--<div> Not have account yet?</div>--%>
                    <%--<div>Please--%>
                    <%--<a href="signup">Sign Up</a> or via social network:--%>
                    <%--</div>--%>
                    <%--<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>--%>
                    <%--</div>--%>
                    <div>
                        <div class="no-have-account">  Have an account already? <a class="no-have-account" href="login">Log in</a>
                        </div>


                        <%--<div>Please--%>
                        <%--<a href="signup">Sign Up</a> or via social network:--%>
                        <%--</div>--%>
                        <%--<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div id="background">
</div>

<footer>
    <div id="footer" class="content">
        <div class="footer">
            <div class="footer-content">
                <h3>About</h3>
                <div class="footer-content-inner">
                    Something about our site
                </div>
            </div>

            <div class="footer-content">
                <h3>Share with friends</h3>
                <div class="footer-content-inner">
                    <div class="footer-content-img">
                        <img src="<c:url value="/pages/images/tw.png"/>"/>
                    </div>
                    <div  class="footer-content-img">
                        <img src="<c:url value="/pages/images/fb.png"/>"/>
                    </div>
                    <div class="footer-content-img">
                        <img src="<c:url value="/pages/images/vk.png"/>"/>
                    </div>
                </div>
            </div>

            <div class="footer-content">
                <h3>Help</h3>
                <div class="footer-content-inner">
                    About help kokoko
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="copyright-text">
                © by
            </div>
            <img src="<c:url value="/pages/images/kokoCo2.png"/>" />
        </div>
    </div>
</footer>

</body>
</html>



<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--<meta name="description" content="">--%>
<%--<meta name="author" content="">--%>

<%--<title>Spring Security</title>--%>
<%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src = "<c:url value="/pages/js/auth_ajax.js" />" ></script>--%>
<%--<link href="<c:url value="/pages/css/auth.css" />" rel="stylesheet">--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class = "logo">--%>
<%--<h1>TravelIt.com</h1>--%>
<%--<h2>Live. Love. Travel </h2>--%>
<%--</div>--%>
<%--<div class = "input_data"><c:url value="/j_spring_security_check" var="loginUrl" />--%>
<%--<div class="login">--%>
<%--<div>--%>
<%--<form:form modelAttribute="user" method="POST" enctype="utf8">--%>

<%--<form:input path="firstName"  placeholder="First Name" autocomplete="off"/>--%>
<%--<form:errors path="firstName" element="div"/>--%>

<%--<form:input path="lastName" placeholder="Last Name" autocomplete="off"/>--%>
<%--<form:errors path="lastName" element="div" />--%>

<%--<form:input path="email" placeholder="E-mail" id="email" value="" autocomplete="off"/>--%>
<%--&lt;%&ndash;<form:errors path="email" element="div" />&ndash;%&gt;--%>
<%--<form:input path="password" value="" placeholder="Password" id="password" type="password" autocomplete="off"/></td>--%>
<%--<form:errors path="password" element="div" />--%>

<%--<form:input path="matchingPassword" value="" id="password" placeholder="Confirm Passsword" type="password" autocomplete="off"/></td>--%>
<%--<form:errors element="div" />--%>

<%--<p> <input type = "submit" value="Sign Up" id = "submit" />--%>
<%--</p>--%>
<%--</form:form>--%>
<%--<br>--%>

<%--&lt;%&ndash;<form action="${loginUrl}" method="post">&ndash;%&gt;--%>

<%--&lt;%&ndash;<!-- fake fields are a workaround for chrome autofill getting the wrong fields -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<input style="display:none" type="text" name="fakeusernameremembered"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input style="display:none" type="password" name="fakepasswordremembered"/>&ndash;%&gt;--%>

<%--&lt;%&ndash;<input type="text" name = "j_username" placeholder = "E-mail" id = "email" autocomplete="off" />&ndash;%&gt;--%>
<%--&lt;%&ndash;<p><input type = "password" name = "j_password" placeholder = "Password" id = "password" autocomplete="off"/></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;<p><input type = "submit" value = "Log In" id = "submit" /><div id = "error">Such user doesn't exist. Try again</div> </p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="add_link">&ndash;%&gt;--%>

<%--&lt;%&ndash;<div> Not have account yet?</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div>Please&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="signup">Sign Up</a> or via social network:&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--<div>--%>
<%--<div class="no-have-account">  Have an account already? <a class="no-have-account" href="login">Log in</a>--%>
<%--</div>--%>


<%--&lt;%&ndash;<div>Please&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href="signup">Sign Up</a> or via social network:&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<a href =""><img src="<c:url value="/pages/images/vk.com.png" />" width = "35px" alt = "Log in via VK" /></a>&ndash;%&gt;--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div id = "background"></div>--%>

<%--</body>--%>
<%--</html>--%>