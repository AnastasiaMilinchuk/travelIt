<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/pages/css/dropzone.css" />" type="text/css" rel="stylesheet" />
    <link href="<c:url value="/pages/css/authorize.css" />" type="text/css" rel="stylesheet" />
    <style>
        #map-canvas {
            width: 500px;
            height: 400px;
            background-color: #CCC;
        }
    </style>
    <%--<script src="<c:url value="/pages/js/jquery.1.9.1.min.js" />"></script>--%>

    <%--<script src="<c:url value="/pages/js/vendor/jquery.ui.widget.js"/>"></script>--%>
    <%--<script src="<c:url value="/pages/js/jquery.iframe-transport.js"/>"></script>--%>

    <%--<script src="<c:url value="/pages/js/jquery.fileupload.js"/>"></script>--%>
    <!-- bootstrap just to have good looking page -->
    <%--<script src="<c:url value="/pages/js/bootstrap.min.js"/>"></script>--%>
    <link href="<c:url value="/pages/css/bootstrap.css"/>" type="text/css" rel="stylesheet" />

    <!-- we code these -->

    <%--<script src="<c:url value="/pages/js/myuploadfunction.js"/>"></script>--%>

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

    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=true_or_false">
    </script>


    <title></title>
</head>
<body>
    <section>
        <%--<sec:authorize access="isAuthenticated()">--%>
            <jsp:include page="templates/upperMenuTempl.jsp"  />
            <form:form method="POST" enctype="multipart/form-data" action="upload" >
                <p>File to upload:</p>
                <form:input path="image" type="file" id = "image" name="image"/>
                <input type="submit" name="action" value="upload" />
            </form:form>

            <form:form modelAttribute="places"  method="POST">
                <fieldset>
                        <div class="selected-places">
                            <h1>My selected places</h1>
                        </div>
                        <div class="added-places">
                            <h1>My added places</h1>
                        </div>
                        <div class="add-own-place">
                                <h1>Add my own place</h1>
                                <div class="add-own-place-container">
                                    <div class="photo">
                                    </div>
                                    <div class="description">
                                        <label>Name:</label>
                                            <form:input path="place.name" type="text"  id = "name" name="name"/>
                                        <br>
                                        <label>Description: </label>
                                            <form:input path="place.description" type="text" id="description" name="description"/>
                                        <br>
                                        <label>Address:</label>
                                             <form:input path="place.address" type="text" id="address" name="address" />
                                        <br>

                                        <div id="map-canvas" class="map">
                                        </div>

                                        <label>Tags</label>
                                            <form:input path="place.tags" name="tags" id="tags"/>
                                        <br>
                                     </div>
                                </div>
                                <input type="submit" name="action" value="save" />
                        </div>
                    </fieldset>
            </form:form>
        <%--</sec:authorize>--%>




        <%--<sec:authorize access="!isAuthenticated()">--%>
            <%--<%--%>
                <%--// Redirecting to login page--%>
                <%--response.setStatus(response.SC_MOVED_TEMPORARILY);--%>
                <%--response.setHeader("Location", "/travelit/login");--%>
            <%--%>--%>
        <%--</sec:authorize>--%>
    </section>

</body>
</html>
