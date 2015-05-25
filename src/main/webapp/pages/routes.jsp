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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="<c:url value="/pages/js/modernizr.js"/>"></script>
    <script id="facebook-jssdk" src="//connect.facebook.net/en_US/sdk.js#xfbml=1&amp;version=v2.0"></script>
    <%--<style>--%>
        <%--.controls {--%>
            <%--margin-top: 16px;--%>
            <%--border: 1px solid transparent;--%>
            <%--border-radius: 2px 0 0 2px;--%>
            <%--box-sizing: border-box;--%>
            <%---moz-box-sizing: border-box;--%>
            <%--height: 32px;--%>
            <%--outline: none;--%>
            <%--box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);--%>
        <%--}--%>
    <%--</style>--%>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&signed_in=true"></script>
    <script src="<c:url value="/pages/js/map_initialize.js"/>"></script>
    <script>
        function initializeAutocomplete() {
//            var mapOptions = {
//                center: {lat: -33.8688, lng: 151.2195},
//                zoom: 13
//            };
//            var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

            var input = /** @type {HTMLInputElement} */(
                    document.getElementById('pac-input'));

            var autocomplete = new google.maps.places.Autocomplete(input);
            autocomplete.bindTo('bounds', map);
//
//            map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

            var infowindow = new google.maps.InfoWindow();
            var marker = new google.maps.Marker({
                map: map
            });
            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map, marker);
            });

            google.maps.event.addListener(autocomplete, 'place_changed', function() {
                infowindow.close();
                var place = autocomplete.getPlace();
                if (!place.geometry) {
                    return;
                }

                if (place.geometry.viewport) {
                    map.fitBounds(place.geometry.viewport);
                } else {
                    map.setCenter(place.geometry.location);
                    map.setZoom(17);
                }

                // Set the position of the marker using the place ID and location
                marker.setPlace({
                    placeId: place.place_id,
                    location: place.geometry.location
                });
                marker.setVisible(true);

                infowindow.setContent('<div><strong>' + place.name + '</strong><br>' +
                        'Place ID: ' + place.place_id + '<br>' +
                        place.formatted_address);
                infowindow.open(map, marker);
            });
        }
        google.maps.event.addDomListener(window, 'load', initializeAutocomplete);
    </script>
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
                        <li><a href="places.html">Places</a>

                        </li>
                        <li class = "active"><a href="routes">Routes</a>
                        </li>

                    </ul>
                </div>
            </div>
        </header>

        <div class="container">
            <h1 class="page-title">History</h1>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <aside class="user-profile-sidebar">
                        <div class="user-profile-avatar text-center">
                            <img src="<c:url value="/pages/images/amaze_300x300.jpg"/>" alt="Image Alternative text" title="AMaze" />
                            <h5></h5>
                            <p>Member Since May 2015</p>
                        </div>
                        <ul class="list user-profile-nav">
                            <li><a href="profile">Overview</a>
                            </li>
                            <li><a href="profile-about">About me</a>
                            </li>
                            <li><a href="user-profile-photos">My Travel Places</a>
                            </li>
                            <li><a href="user-profile-booking-history">History</a>
                            </li>
                        </ul>
                    </aside>
                </div>
                <div class="col-md-9">
                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <%--<h4 class="modal-title" id="myModalLabel">Modal title</h4>--%>
                                    <input class = "modal-title" placeholder = "Input name of tour" />
                                </div>
                                <div class="modal-body">
                                    <label>Input city</label><br><input id="pac-input" class="controls" type="text"
                                           placeholder="City" /><br><br>
                                    <label>Choose date</label><br><input type="date" class="form-control" />
                                    <br><br>
                                    <div id="map-canvas"></div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row row-wrap">
                        <div class="col-md-4 add_route">
                            <div class="thumb">
                                <a href="#" class="btn btn-primary btn-lg add-new-route" data-toggle="modal" data-target="#myModal">
                                    Create new route
                                </a>
                                <script>
                                    $('.add-new-route').click('shown.bs.modal', function() {
                                        initialize();
                                        initializeAutocomplete();
                                        alert("olol");

//                               google.maps.event.trigger(map, 'resize');
                                    });
                                </script>
                            </div>
                        </div>
                        <%--<div class="col-md-4">--%>
                            <%--<div class="thumb">--%>
                                <%--<a class="hover-img" href="#">--%>
                                    <%--<img src="http://extreme-weekend.com.ua/assets/cacheimg/104-92578-255-382.pageCache.jpg" alt="Image Alternative text" title="Gaviota en el Top">--%>
                                    <%--<div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">--%>
                                        <%--<div class="text-small">--%>
                                            <%--<h5>Bakota. Ukraine</h5>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="col-md-4">
                            <div class="thumb">
                                <a class="hover-img" href="#">
                                    <img src="http://wyr.com.ua/files/Statti/9%20malovidomix%20misc%20Zaxidnoji%20Ukrajini/tarakanivskij%20fort.JPG" alt="Image Alternative text" title="Sydney Harbour">
                                    <div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">
                                        <div class="text-small">
                                            <h5>Tarakanivskiy fort. Ukraine</h5>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="thumb">
                                <a class="hover-img" href="#">
                                    <img src="http://wyr.com.ua/files/Statti/9%20malovidomix%20misc%20Zaxidnoji%20Ukrajini/dzhurinskij%20vodospad.jpg" alt="Image Alternative text" title="Street">
                                    <div class="hover-inner hover-inner-block hover-inner-bottom hover-inner-bg-black hover-hold">
                                        <div class="text-small">
                                            <h5>Nyrkiv. Ternopilska oblast'/ Ukraine</h5>
                                            <p>72528 reviews</p>
                                            <p class="mb0">663 offers from $67</p>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
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
                    <h4>Total Traveled</h4>
                    <ul class="list list-inline user-profile-statictics mb30">
                        <li><img src="<c:url value="/pages/images/miles.svg"/>" alt="Image Alternative text" title="AMaze" />
                            <h5>12540</h5>
                            <p>Miles</p>
                        </li>
                        <li><img src="<c:url value="/pages/images/earth.png"/>" alt="Image Alternative text" title="AMaze" />
                            <h5>2%</h5>
                            <p>World</p>
                        </li>
                        <li><img src="<c:url value="/pages/images/cities.png"/>" alt="Image Alternative text" title="AMaze" />
                            <h5>15</h5>
                            <p>Cities</p>
                        </li>
                        <li><img src="<c:url value="/pages/images/flag.png"/>" alt="Image Alternative text" title="AMaze" />
                            <h5>3</h5>
                            <p>Countries</p>
                        </li>
                        <li><img src="<c:url value="/pages/images/trip.png"/>" alt="Image Alternative text" title="AMaze" />
                            <h5>20</h5>
                            <p>Trips</p>
                        </li>
                    </ul>
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