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
    <link rel="stylesheet" href="<c:url value="/pages/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/icomoon.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/styles.css"/>">
    <link rel="stylesheet" href="<c:url value="/pages/css/mystyles.css"/>">
    <script id="facebook-jssdk" src="//connect.facebook.net/en_US/sdk.js#xfbml=1&amp;version=v2.0"></script>
    <script src="js/modernizr.js"></script>
    <link rel="stylesheet" href="css/switcher.css">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/bright-turquoise.css"/>" title="bright-turquoise" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/turkish-rose.css"/>" title="turkish-rose" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/salem.css"/>" title="salem" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/hippie-blue.css"/>" title="hippie-blue" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/mandy.css"/>" title="mandy" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/green-smoke.css"/>" title="green-smoke" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/horizon.css"/>" title="horizon" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/cerise.css"/>" title="cerise" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/brick-red.css"/>" title="brick-red" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/de-york.css"/>" title="de-york" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/shamrock.css"/>" title="shamrock" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/studio.css"/>" title="studio" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/leather.css"/>" title="leather" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/denim.css"/>" title="denim" media="all">
    <link rel="alternate stylesheet" type="text/css" href="<c:url value="/pages/css/schemes/scarlet.css"/>" title="scarlet" media="all">

    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script>
        function initialize() {
            var mapCanvas = document.getElementById('map-canvas');
            var mapOptions = {
                center: new google.maps.LatLng(44.5403, -78.5463),
                zoom: 8,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            }
            var map = new google.maps.Map(mapCanvas, mapOptions)
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>

</head>

<body>

<!-- FACEBOOK WIDGET -->
<div id="fb-root">

</div>
<script>
    (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>


<!-- /FACEBOOK WIDGET -->
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
                        <div class="form-group form-group-icon-left">
                            <i class="fa fa-search input-icon"></i>
                            <input type="text" class="form-control">
                        </div>
                    </form>
                </div>
                <div class="col-md-4">
                    <div class="top-user-area clearfix">
                        <ul class="top-user-area-list list list-horizontal list-border">
                            <li class="top-user-area-avatar">
                                <a href="user-profile.html">
                                    <img class="origin round" src="img/amaze_40x40.jpg" alt="Image Alternative text" title="AMaze" />Hi, John</a>
                            </li>
                            <li><a href="#">Sign Out</a>
                            </li>

                            <li class="top-user-area-lang nav-drop">
                                <a href="#">
                                    <img src="img/flags/32/uk.png" alt="Image Alternative text" title="Image Title" />ENG<i class="fa fa-angle-down"></i><i class="fa fa-angle-up"></i>
                                </a>
                                <ul class="list nav-drop-menu">

                                    <li>
                                        <a title="Ukrainian" href="#">
                                            <img src="img/flags/32/ru.png" alt="Image Alternative text" title="Image Title" /><span class="right">UA</span>
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
    <li><a href="index.html">Home</a>
    </li>
    <li class="active"><a href="success-payment.html">Profile</a>
    </li>
    <li><a href="feature-typography.html">Places</a>

    </li>
    <li><a href="hotels.html">Routes</a>
    </li>

    </ul>
    </div>
</div>
</header>

<div class="container">
    <h1 class="page-title">Travel Profile</h1>
</div>




<div class="container">
    <div class="row">
        <div class="col-md-3">
            <aside class="user-profile-sidebar">
                <div class="user-profile-avatar text-center">
                    <img src="img/amaze_300x300.jpg" alt="Image Alternative text" title="AMaze" />
                    <h5></h5>
                    <p>Member Since May 2012</p>
                </div>
                <ul class="list user-profile-nav">
                    <li><a href="user-profile.html"><i class="fa fa-user"></i>Overview</a>
                    </li>
                    <li><a href="user-profile-settings.html"><i class="fa fa-cog"></i>Settings</a>
                    </li>
                    <li><a href="user-profile-photos.html"><i class="fa fa-camera"></i>My Travel Places</a>
                    </li>
                    <li><a href="user-profile-booking-history.html"><i class="fa fa-clock-o"></i>History</a>
                    </li>
                    <li><a href="user-profile-wishlist.html"><i class="fa fa-heart-o"></i>Wish list</a>
                    </li>
                </ul>
            </aside>
        </div>
        <div class="col-md-9">
            <h4>Total Traveled</h4>
            <ul class="list list-inline user-profile-statictics mb30">
                <li><i class="fa fa-dashboard user-profile-statictics-icon"></i>
                    <h5>12540</h5>
                    <p>Miles</p>
                </li>
                <li><i class="fa fa-globe user-profile-statictics-icon"></i>
                    <h5>2%</h5>
                    <p>World</p>
                </li>
                <li><i class="fa fa-building-o user-profile-statictics-icon"></i>
                    <h5>15</h5>
                    <p>Cityes</p>
                </li>
                <li><i class="fa fa-flag-o user-profile-statictics-icon"></i>
                    <h5>3</h5>
                    <p>Countries</p>
                </li>
                <li><i class="fa fa-plane user-profile-statictics-icon"></i>
                    <h5>20</h5>
                    <p>Trips</p>
                </li>
            </ul>
            <div id="map-canvas" style="width:100%; height:400px;"></div>
        </div>
    </div>
</div>



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
    <script src="<c:url value="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"/>"></script>
    <script src="<c:url value="https://maps.gstatic.com/maps-api-v3/api/js/20/11/main.js"/>"></script>
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

</body>
</html>