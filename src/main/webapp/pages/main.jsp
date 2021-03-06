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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.js">
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
                            <a class="logo" href="salesman.jsp">
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
                        <li><a href="routes">Routes</a>
                        </li>
                        <li><a href="salesman">Salesman</a>
                        </li>

                    </ul>
                </div>
            </div>
        </header>
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="http://foto.ua/uploads/photos/344/344692_2.jpeg" style="left: 0px;z-index: -2;">
                    <div class="carousel-caption">
                        <div class = "block">
                            <div class = "circle ctitle"><span>Pastoral Summer Landscapes of Transcarpathia</span></div>
                            <div class = "circle cdescr"><span>Zakarpattia (Transcarpathia) region is located on the south-western slopes and foothills of the Eastern Carpathians.</span></div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="http://img-fotki.yandex.ru/get/6306/19526786.1f/0_741b3_327e059f_XXXL.jpg" alt="...">
                    <div class="carousel-caption">
                        <div class = "block">
                            <div class = "circle ctitle"><span>Crocuses Transcarpathia</span></div>
                            <div class = "circle cdescr"><span>Go to the Carpathian mountains in spring and look at the field of crocuses</span></div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="http://igormelika.com.ua/wp-content/gallery/stezhkami-karpat/igor-melika-30-09-02-10-11-48.jpg" alt="...">
                    <div class="carousel-caption">
                        <div class = "block">
                            <div class = "circle ctitle"><span>Pastoral Summer Landscapes of Transcarpathia</span></div>
                            <div class = "circle cdescr"><span>Zakarpattia (Transcarpathia) region is located on the south-western slopes and foothills of the Eastern Carpathians.</span></div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="http://uatravel.org/wp-content/uploads/2014/12/wpid-sonyachn-karpati_i_1.jpg" alt="...">
                    <div class="carousel-caption">
                        <div class = "block">
                            <div class = "circle ctitle"><span>Pastoral Summer Landscapes of Transcarpathia</span></div>
                            <div class = "circle cdescr"><span>Zakarpattia (Transcarpathia) region is located on the south-western slopes and foothills of the Eastern Carpathians.</span></div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <br>
        <h1 class = "title">Have you ever been here?</h1><br>
        <div class = "container" >
            <c:forEach items="${places}" var="place">
                <a href="place?id=${place.id}">
                    <article class = "col-md-4 place_block">
                        <div class = "place_block_img">
                            <img src="${place.photo}" alt = "Dubno, Rivnenska obl" class="img-thumbnail"/>
                        </div>
                        <div class = "description_place">
                            <h2>${place.name}</h2>
                            <div class= "place_detail_info">Creator ${place.creatorEmail}
                                <span class = "number_visits">${place.subscribes}</span>
                            </div>
                        </div>
                    </article>
                </a>
            </c:forEach>
        </div>
        <a href = ""><div class="btnn">Look more</div></a>

        <div class="gap"></div>
        <jsp:include page="templates/footer.jsp"  />

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