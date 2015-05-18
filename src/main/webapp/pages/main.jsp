<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <title>TravelIt - Travel Profile</title>

    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- GOOGLE FONTS -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600' rel='stylesheet' type='text/css'>
    <!-- /GOOGLE FONTS -->
    <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/pages/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/icomoon.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/mystyles.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/main.css"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="<c:url value="/pages/js/modernizr.js"/>"></script>
    <script id="facebook-jssdk" src="//connect.facebook.net/en_US/sdk.js#xfbml=1&amp;version=v2.0"></script>
</head>
<body>
<sec:authorize access="isAuthenticated()">
<div class="global-wrap">
<header id="main-header">
    <div class="header-top">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <a class="logo" href="index.html">
                        <%--<img src="<c:url value="/pages/images/login/logoEarth1.png" />" alt="Image Alternative text" title="Image Title" />--%>
                    </a>
                </div>
                <div class="col-md-3 col-md-offset-2">
                    <form class="main-header-search">
                        <div class="form-group form-group-icon-right">
                            <i class="form-control-feedback glyphicon glyphicon-search"></i>
                            <input type="text" class="form-control">
                        </div>
                    </form>
                </div>

                <div class="col-md-4">
                    <div class="top-user-area clearfix">
                        <ul class="top-user-area-list list list-horizontal list-border">
                            <li class="top-user-area-avatar">
                                <a href="profile">
                                    <img class="origin round" src="<c:url value="/pages/images/amaze_40x40.jpg"/>" alt="Image Alternative text" title="AMaze" />Hi, Julia</a>
                            </li>
                            <li><a href='<c:url value="/logout" />'>Sign Out</a>
                            </li>

                            <li class="top-user-area-lang nav-drop">
                                <a href="#">
                                    <img src="<c:url value="/pages/images/flag/uk.png"/>" alt="Image Alternative text" title="Image Title" />ENG<i class="glyphicon glyphicon-menu-down"></i>
                                </a>
                                <ul class="list nav-drop-menu">

                                    <li>
                                        <a title="Ukrainian" href="#">
                                            <img src="<c:url value="/pages/images/flag/ua.png"/>" alt="Image Alternative text" title="Image Title" /><span class="right">UA</span>
                                        </a>
                                    </li>

                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
    <div class="nav">
    <ul class="slimmenu" id="slimmenu">
    <li class="active"><a href="main.html">Home</a>
    </li>
    <li><a href="profile">Profile</a>
    </li>
    <li><a href="places.html">Places</a>

    </li>
    <li><a href="achievements.html">Routes</a>
    </li>

    </ul>
    </div>
</div>
</header>
    <div class = "main_block">
        <img src="http://foto.ua/uploads/photos/344/344692_2.jpeg" style="-webkit-backface-visibility: hidden; position: absolute; left: 0px; z-index: -2; max-width: none; height: 100%; width: 1296px;">
        <div class = "cont">
            <div class="nav1">
                <a href="#" class = "prev"><span class = "glyphicon glyphicon-chevron-left"></span></a>
                <!-- <div class = "left">P</div> -->
                <a href="#" class = "next"><span class = "glyphicon glyphicon-chevron-right"></span></a>
            </div>
            <div class = "block">
                <div class = "circle ctitle"><span>Transcarpathia</span></div>
                <div class = "circle cdescr"><span>Zakarpattia (Transcarpathia) region is located on the south-western slopes and foothills of the Eastern Carpathians.</span></div>
            </div>
        </div>
    </div>
    <br>
    <h1 class = "title">Have you ever been here?</h1><br>
    <div class = "container" >
        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ic.pics.livejournal.com/veremia/39760178/23663/original.jpg" alt = "Dubno, Rivnenska obl" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Tarakanivskiy fort</h2>
                <p>Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/04/chervonograd-palace-remains-ternopil-region-ukraine-1-small.jpg" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Ternopil</h2>
                <p>Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://odisej2012.com/wp-content/uploads/2015/04/%D0%A5%D0%BE%D1%82%D0%B8%D0%BD13.jpg" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Hotyn</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing eliincididunt ut</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/04/kamenets-podolskiy-city-museum-ukraine-1-small.jpg" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Kamenets-Podolskyi</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed d tempor incididunt ut </p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/03/nicholas-cathedral-organ-music-house-kiev-ukraine-1-small.jpg" alt = "Dubno, Rivnenska obl" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Kyiv</h2>
                <p>Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="photo/img_3788-1.jpg" class="img-thumbnail" />
            </div>
            <div class = "description_place">
                <h2>Uzhgorord</h2>
                <p>Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://odisej2012.com/wp-content/uploads/2015/04/%D0%A5%D0%BE%D1%82%D0%B8%D0%BD13.jpg" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Hotyn</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing eliincididunt ut</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/04/kamenets-podolskiy-city-museum-ukraine-1-small.jpg" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Kamenets-Podolskyi</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed d tempor incididunt ut </p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

        <article class = "col-md-4 place_block">
            <div class = "place_block_img">
                <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/03/nicholas-cathedral-organ-music-house-kiev-ukraine-1-small.jpg" alt = "Dubno, Rivnenska obl" class="img-thumbnail"/>
            </div>
            <div class = "description_place">
                <h2>Kyiv</h2>
                <p>Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div></div>
        </article>

    </div>
    <a href = ""><div class="btnn">Look more</div></a>

<div class="gap"></div>
<footer id="main-footer">
    <div class="container">
        <div class="row row-wrap">
        <div class="col-md-3">
        <a class="logo" href="">
        <img src="img/logo-invert.png" alt="Image Alternative text" title="Image Title" />
        </a>
        <p class="mb20">Booking, reviews and advices on hotels, resorts, flights, vacation rentals, travel packages, and lots more!</p>
        <ul class="list list-horizontal list-space">
        <li>
        <a class="fa fa-facebook box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
        </li>
        <li>
        <a class="fa fa-twitter box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
        </li>
        <li>
        <a class="fa fa-google-plus box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
        </li>
        <li>
        <a class="fa fa-linkedin box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
        </li>
        <li>
        <a class="fa fa-pinterest box-icon-normal round animate-icon-bottom-to-top" href="#"></a>
        </li>
        </ul>
        </div>

        <div class="col-md-3">
        <h4>Newsletter</h4>
        <form>
        <label>Enter your E-mail Address</label>
        <input type="text" class="form-control"/>
        <p class="mt5"><small>*We Never Send Spam</small>
        </p>
        <input type="submit" class="btn btn-primary" value="Subscribe"/>
        </form>
        </div>
        <div class="col-md-2">
        <ul class="list list-footer">
        <li><a href="#">About US</a>
        </li>
        <li><a href="#">Press Centre</a>
        </li>
        <li><a href="#">Best Price Guarantee</a>
        </li>
        <li><a href="#">Travel News</a>
        </li>
        <li><a href="#">Jobs</a>
        </li>
        <li><a href="#">Privacy Policy</a>
        </li>
        <li><a href="#">Terms of Use</a>
        </li>
        <li><a href="#">Feedback</a>
        </li>
        </ul>
        </div>
        <div class="col-md-4">
        <h4>Have Questions?</h4>
        <h4 class="text-color">+1-202-555-0173</h4>
        <h4><a href="#" class="text-color">support@traveler.com</a></h4>
        <p>24/7 Dedicated Customer Support</p>
        </div>

        </div>
    </div>
</footer>

    <script src="<c:url value='/pages/js/jquery.js'/>"></script>
    <script src="<c:url value="/pages/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/pages/js/slimmenu.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap-datepicker.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap-timepicker.js"/>"></script>
    <script src="<c:url value="/pages/js/nicescroll.js"/>"></script>
    <script src="<c:url value="/pages/js/dropit.js"/>"></script>
    <script src="<c:url value="/pages/js/ionrangeslider.js"/>"></script>
    <script src="<c:url value="/pages/js/icheck.js"/>"></script>
    <script src="<c:url value="/pages/js/fotorama.js"/>"></script>
    <%--<script src="<c:url value="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"/>"></script>--%>
    <%--<script src="<c:url value="https://maps.gstatic.com/maps-api-v3/api/js/20/11/main.js"/>"></script>--%>
    <script src="<c:url value="/pages/js/typeahead.js"/>"></script>
    <script src="<c:url value="/pages/js/card-payment.js"/>"></script>
    <script src="<c:url value="/pages/js/magnific.js"/>"></script>
    <script src="<c:url value="/pages/js/owl-carousel.js"/>"></script>
    <script src="<c:url value="/pages/js/fitvids.js"/>"></script>
    <script src="<c:url value="/pages/js/tweet.js"/>"></script>
    <script src="<c:url value="/pages/js/countdown.js"/>"></script>
    <script src="<c:url value="/pages/js/gridrotator.js"/>"></script>
    <script src="<c:url value="/pages/js/custom.js"/>"></script>
    <script src="<c:url value="/pages/js/switcher.js"/>"></script>
</div>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <%
        // Redirecting to login page
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "/travelit/login");
    %>
</sec:authorize>
</body>
</html>