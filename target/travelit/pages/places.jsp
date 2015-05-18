<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <style>
        #map-canvas {
            width: 500px;
            height: 400px;
            background-color: #CCC;
        }
    </style>
    <script src="js/jquery.1.9.1.min.js"></script>

    <script src="js/vendor/jquery.ui.widget.js"></script>
    <script src="js/jquery.iframe-transport.js"></script>
    <script src="js/jquery.fileupload.js"></script>

    <!-- bootstrap just to have good looking page -->
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet" />

    <!-- we code these -->
    <link href="css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="js/myuploadfunction.js"></script>

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
        <sec:authorize access="isAuthenticated()">
            <jsp:include page="templates/upperMenuTempl.jsp"  />
            <div style="width:500px;padding:20px">

                <input id="fileupload" type="file" name="files[]" data-url="rest/controller/upload" multiple>

                <div id="dropzone">Drop files here</div>

                <div id="progress">
                    <div style="width: 0%;"></div>
                </div>

                <table id="uploaded-files">
                    <tr>
                        <th>File Name</th>
                        <th>File Size</th>
                        <th>File Type</th>
                        <th>Download</th>
                    </tr>
                </table>

            </div>

            <div class="selected-places">
                <h1>My selected places</h1>
            </div>

            <div class="added-places">
                <h1>My added places</h1>
            </div>

            <div class="add-own-place">
                <form action="<c:url value="/places"/>" method="post" enctype="multipart/form-data">
                    <h1>Add my own place</h1>
                    <div class="add-own-place-container">
                        <div class="photo">
                        </div>
                        <div class="description">

                            <label>Name:</label>
                            <input id="name" name="name"/>
                            <br>
                            <label>Description: </label>
                            <input id="description" name="description"/>
                            <br>
                            <label>Address:</label>
                            <input id="address" name="address" />
                            <br>
                            <div id="map-canvas" class="map">
                            </div>

                            <label>Tags</label>
                            <input id="tags"/>
                            <br>

                            <label>File to upload:</label>
                            <input type="file" name="file"><br />

                         </div>
                    </div>
                    <button type="submit">Save</button>

                </form>
            </div>
        </sec:authorize>




        <sec:authorize access="!isAuthenticated()">
            <%
                // Redirecting to login page
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", "/travelit/login");
            %>
        </sec:authorize>
    </section>

</body>
</html>
