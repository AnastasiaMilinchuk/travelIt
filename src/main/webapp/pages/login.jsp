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
    <link href="<c:url value="/pages/css/authorize.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/footer.css" />" rel="stylesheet">
</head>

<body>
    <header>
    </header>

    <section >
        <div class = "article">
            <h1>Sign In</h1>
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
                        <form action="${loginUrl}" method="post">

                            <!-- fake fields are a workaround for chrome autofill getting the wrong fields -->
                            <input style="display:none" type="text" name="fakeusernameremembered"/>
                            <input style="display:none" type="password" name="fakepasswordremembered"/>

                            <input type="text" name = "j_username" placeholder = "E-mail" id = "email"  value="admin@gmail.com" />
                            <input type = "password" name = "j_password" placeholder = "Password" id = "password" value="1234"/>
                            <p><input type = "submit" value = "Log In" id = "submit" /><div id = "error">Such user doesn't exist. Try again</div> </p>
                        </form>
                    </div>
                    <div class="signup">
                        Not have account yet? Please  <a class="no-have-account" href="signup">Sign Up</a>.
                    </div>
                </div>
           </div>
        </div>
    </section>
    <div id="background"></div>

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
