<%--
  Created by IntelliJ IDEA.
  User: milinchuk
  Date: 4/4/15
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Main</title>
    <link href="<c:url value="/pages/css/main.css" />" rel="stylesheet">
    <link href="<c:url value="/pages/css/header.css" />" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src = "<c:url value="/pages/js/header_menu.js" />" ></script>

</head>
<body>
    <sec:authorize access="isAuthenticated()">
         <%--<a href='/travelit/profile' >I am</a>--%>
         <%--<a href='/travelit/places' >That I am</a>--%>
         <%--<a href='/travelit/achievements' >Achievements</a>--%>
         <%--<a href='<c:url value="/logout" />' >Log out</a>--%>
        <%--<p>E-mail: <sec:authentication property="principal.username" /></p>--%>

        <div class = "header">
            <a href = "main.html" ><h1>TravelIt </h1></a><hr>
            <div class = "toolbar_button history_button"></div><hr>
            <div class = "toolbar_button map_button"></div><hr>
            <div class = "toolbar_button user_profile_button"></div><hr>
            <div class = "toolbar_icon_menu">
                <ul class = "icon_menu">
                    <li>My profile</li>
                    <li>Settings</li>
                    <li><a href='<c:url value="/logout" />'>Log out</a></li>
                </ul>
            </div>
        </div>
        <div class = "cont">
            <!-- <h1>Have you ever been there?</h1><br><br> -->
            <article class = "big_block">
                <div class = "big_block_image"></div>
                <div class="big_block_description">
                    <h1>Pastoral Summer Landscapes of Transcarpathia</h1>
                    <p>Zakarpattia (Transcarpathia) region is located on the south-western slopes and foothills of the Eastern Carpathians. Carpathian Mountains cover about 80% of its territory. This region borders with four countries: Romania, Hungary, Slovakia, and Poland.
                    </p>
                    <div class= "place_detail_info">Creator Mapator
                        <span class = "number_visits">15</span>
                    </div>
                </div>
            </article>
            <br><br><h1 class = "title">Have you ever been here?</h1><br><br>
            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://ic.pics.livejournal.com/veremia/39760178/23663/original.jpg" alt = "Dubno, Rivnenska obl" />
                </div>
                <h2>Tarakanivskiy fort</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>

            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/04/chervonograd-palace-remains-ternopil-region-ukraine-1-small.jpg"/>
                </div>
                <h2>Ternopil</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>

            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://odisej2012.com/wp-content/uploads/2015/04/%D0%A5%D0%BE%D1%82%D0%B8%D0%BD13.jpg" />
                </div>
                <h2>Hotyn</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amet, consectetur adipisicing eliincididunt ut</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>

            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/04/kamenets-podolskiy-city-museum-ukraine-1-small.jpg" />
                </div>
                <h2>Kamenets-Podolskyi</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed d tempor incididunt ut </p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>

            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/03/nicholas-cathedral-organ-music-house-kiev-ukraine-1-small.jpg" alt = "Dubno, Rivnenska obl" />
                </div>
                <h2>Kyiv</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>

            <article class = "place_block">
                <div class = "place_block_img">
                    <img src="http://ukrainetrek.com/blog/wp-content/uploads/2015/03/uzhhorod-city-architecture-ukraine-1-small.jpg" alt = "Dubno, Rivnenska obl" />
                </div>
                <h2>Uzhgorord</h2>
                <p class = "description_place">
                    Lorem ipsum dolor sit amesed do eiusmod tempor incididunt ut labore et dolore magna</p>
                <div class= "place_detail_info">Creator Mapator
                    <span class = "number_visits">15</span>
                </div>
            </article>
        </div>


        <%--<p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">logout</a></p>--%>
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
