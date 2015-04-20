<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <script type="text/javascript" src = "<c:url value="/pages/js/jquery.min.js" />" ></script>
    <script type="text/javascript" src = "<c:url value="/pages/js/index.js" />" ></script>
    <script type="text/javascript" src = "<c:url value="/pages/js/jquery.BlackAndWhite.js" />" ></script>

    <link href="<c:url value="/pages/css/auth.css" />" rel="stylesheet">

    <title>Spring Security</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <%--<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">--%>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>-->
    <!--[endif]-->
</head>

<body>
<section class="content">
        <div class="main-img">
        </div>

    <section class="container">
        <div class="page-header">
            <h1 class="slogan" >Discover your Motherland. Detect something new.</h1>
        </div>


        <div class="navigator">
        </div>

        <div class="logotype">
           <img class="main-logo" src='<c:url value="/pages/images/travelItLogo1.png"/>' />
        </div>

        <div class="dare">
            <div id="begin">
                <img class="imag" src='<c:url value="/pages/images/circle6.png"/>'/>
            </div>
        </div>

        <div class="authorize">
            <div class="authorize-frame">
                <div class="signin">
                    Sign In
                </div>
                <%--<div class="signup">--%>
                    <%--Sign Up--%>
                <%--</div>--%>
            </div>
        </div>
    </section>

</section>
    <section class="content">
        <div class="what-it-about">
            <div class="article">
                <h2>What it is about?</h2>
            </div>

            <div class="what-it-about-content-grid">
                <div class="what-it-about-content">
                        <img  class="what-it-about-img" src="http://de-tur.com/wp-content/uploads/2014/05/20130609111100.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>

                <div class="what-it-about-content">
                    <img  class="what-it-about-img" src="http://hottour.dp.ua/_bl/650/53329292.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>

                <div class="what-it-about-content">
                    <img  class="what-it-about-img" src="http://lux.fm/resources/img/gallery/news/optimized/229390.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>

                <div class="what-it-about-content">
                    <img  class="what-it-about-img" src="http://toursdekiev.com.ua/files/Ch_lavra_night.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>

                <div class="what-it-about-content">
                    <img  class="what-it-about-img" src="http://www.asergeev.com/p/xl-2004-409-05/odessa_ukraine_august-seaport_marina_evening_odessa_ukraine.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>

                <div class="what-it-about-content">
                    <img  class="what-it-about-img" src="http://bookvachka.org.ua/photos/karpaty_may/karpaty_28.jpg"/>
                    <div class="what-it-about-text">
                        <div class="h3-text">Tradition</div>
                        <div class="p-text">Find more for your entertainment.</div>
                    </div>
                </div>
            </div>
        </div>
    </section>

<section style="margin-top: 5%" class="what-it-about">
    <%--<div  class="article">--%>
        <%--<h2>Behind this site</h2>--%>
    <%--</div>--%>

    <div class="what-it-behind-background">
    </div>
        <div class="what-it-behind-grid">
            <div class="what-it-behind">
                <div class="what-it-behing-section">
                    <h3>
                        Find Interesting place here.
                    </h3>
                    <p>
                        Register and bla bla bla. Enjoy kokoko kokoko kookoko.
                    </p>
               </div>
                <div class="what-it-behing-section">
                    <img class="what-it-behind-img" src="<c:url value="/pages/images/compass.png"/>">
                </div>
            </div>

            <div class="what-it-behind">
                <div class="what-it-behing-section">
                    <%--<img  class="what-it-behind-img" src="https://camo.githubusercontent.com/32f003ab003acc6e59c5133fb0c1a0ef8e06a24e/68747470733a2f2f662e636c6f75642e6769746875622e636f6d2f6173736574732f3334373533372f3438393037352f61646332383639612d623938662d313165322d383131642d3661336563646331376233642e706e67">--%>
                </div>
                <div style="text-align: right;" class="what-it-behing-section">
                    <h3>
                        ... Or share own
                    </h3>
                    <p>
                        Register and bla bla bla. Enjoy kokoko kokoko kookoko.
                    </p>
                </div>
            </div>
        </div>

</section>

<section>
    <section class="content">
        <div class="article">
            <h2>How it works?</h2>
        </div>
        <div class="what-it-about-content-grid">
            <div class="what-it-about-content">
                <img src="">
            </div>
        </div>
    </section>
</section>

</body>
</html>

<%--rgb(125, 187, 108)--%>


<%--<div class="jumbotron" style="margin-top: 20px;">--%>
    <%--<h1>TravelIt.com</h1>--%>
    <%--<p class="lead">Live. Love. Travel.</p>--%>
    <%--<sec:authorize access="!isAuthenticated()">--%>
        <%--<p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Login</a></p>--%>
    <%--</sec:authorize>--%>
<%--</div>--%>

<%--<div class="footer">--%>
    <%--<p>&copy; TravelIt 2015</p>--%>
<%--</div>--%>

