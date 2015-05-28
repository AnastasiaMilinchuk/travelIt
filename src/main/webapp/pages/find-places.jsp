<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="<c:url value="/pages/css/input/fileinput.css"/>" media="all" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="<c:url value="/pages/js/input/fileinput.min.js"/>"></script>
    <script src="<c:url value="/pages/js/input/fileinput_locale_uk.js"/>"></script>
    <script src="<c:url value="/pages/js/modernizr.js"/>"></script>
    <script id="facebook-jssdk" src="//connect.facebook.net/en_US/sdk.js#xfbml=1&amp;version=v2.0"></script>
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script>
        function initialize() {
            var mapCanvas = document.getElementById('map-canvas');
            var myLatLng = new google.maps.LatLng(50.447585, 30.452310);
            var mapOptions = {
                center: myLatLng,
                zoom: 10,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            var map = new google.maps.Map(mapCanvas, mapOptions);

            if(navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {
                    var pos = new google.maps.LatLng(position.coords.latitude,
                            position.coords.longitude);

                    map.setCenter(pos);
                }, function() {
                    handleNoGeolocation(true);
                });
            } else {
                // Browser doesn't support Geolocation
                handleNoGeolocation(false);
            }
        }
        //google.maps.event.addDomListener(window, 'load', initialize);

        //        $('.add-place').click('shown.bs.collapse', function() {
        //            alert("olol");
        ////            google.maps.event.trigger(map, 'resize');
        //        });
    </script>
    <!--Load google map after open tab-->
    <%--<script>--%>
    <%--$('.add-place').click('shown.bs.collapse', function() {--%>
    <%--google.maps.event.trigger(map, 'resize');--%>
    <%--});--%>
    <%--</script>--%>
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
                <li><a href="main.html">Home</a>
                </li>
                <li><a href="profile">Profile</a>
                </li>
                <li class = "active"><a href="places.html">Places</a>

                </li>
                <li><a href="routes">Routes</a>
                </li>

            </ul>
        </div>
    </div>
</header>

<div class="container">
    <h1 class="page-title">Find Places</h1>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-11">
            <form:form modelAttribute="places" method="POST">
                <h1>Choose city:</h1>
                <select>
                    <option>Kiev</option>
                    <option>Lviv</option>
                    <option>Odessa</option>
                </select>

                <fieldset>
                    <div class="selected-places">
                        <h1>Recomended Places</h1>
                        <div class="row row-wrap">
                            <div class="col-md-4">
                                <div class="thumb">
                                    <a class="hover-img" href="place?id=${place.id}">
                                        <img src="http://extreme-weekend.com.ua/assets/cacheimg/104-92578-255-382.pageCache.jpg" alt="Image Alternative text" title="Gaviota en el Top">
                                        <div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">
                                            <div class="text-small">
                                                <h5>Bakota. Ukraine</h5>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="thumb">
                                    <a class="hover-img" href="#">
                                        <img src="http://allbooking.com.ua/images/Articles/top-10-najkrasyvishyh-misc-ukraini/10/10_1.jpg" alt="Image Alternative text" title="lack of blue depresses me">
                                        <div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">
                                            <div class="text-small">
                                                <h5>Gurzuf</h5>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="added-places">
                        <h1>My added places</h1>
                        <div class="row row-wrap">
                            <div class="col-md-4">
                                <div class="thumb">
                                    <a class="hover-img" href="#">
                                        <img src="http://allbooking.com.ua/images/Articles/top-10-najkrasyvishyh-misc-ukraini/5/5.jpg" alt="Image Alternative text" title="the journey home">
                                        <div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">
                                            <div class="text-small">
                                                <h5>Sevastopol'</h5>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>

<div class="gap"></div>

<footer id="main-footer">
    <div class="container">
        <div class="row row-wrap">
            <div class="col-md-4">
                <a class="logo" href="">
                    <img src="<c:url value = "/pages/img/logo-invert.png"/>" alt="Image Alternative text" title="Image Title" />
                </a>
                <p class="mb20">TravelIt help you with planning of trips, sharing and saving of wonderful places</p>
            </div>

            <div class="col-md-4">
                <h4>Newsletter</h4>
                <form>
                    <label>Enter your E-mail Address</label>
                    <input type="text" class="form-control"/>
                    <p class="mt5"><small>*We Never Send Spam</small>
                    </p>
                    <input type="submit" class="btn btn-primary" value="Subscribe"/>
                </form>
            </div>
                <%--<div class="col-md-2"></div>--%>
            <div class="col-md-4">
                <h4>Authors</h4>
                <h4 class="text-color">Artem Malinovskiy</h4>
                <h4 class="text-color">Anastasia Milinchuk</h4>
                <h4 class="text-color">Tanya Syagailo</h4>
                <h4 class="text-color">Julia Hrihorieva</h4>
                <h4 class="text-color">Nikita Orlov</h4>
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
