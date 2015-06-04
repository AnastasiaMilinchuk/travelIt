<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<c:url value="/pages/css/mystyles.css"/>">
</head>
<body>
    <sec:authorize access="isAuthenticated()">
        <div class="selected_place_cont">
            <jsp:include page="templates/header.jsp" />
            <div class="selected-place">
            <form:form modelAttribute="place" action="${action}" method="POST" enctype="utf8">
                <img class = "place_block_img"  src='<c:url value="${place.photo}"/>' /><br>
                <div class = "description">
                    <label id = "name"><c:out value="${place.name}"/></label><br>
                    <label><c:out value="${place.description}"/></label><br>
                   <div class="additional">
                    <label>Address: </label><label><c:out value="${place.address}"/></label><br>
                    <label>Author's email: </label><label><c:out value="${place.creatorEmail}"/></label><br>
                    <label><c:out value="${place.dateOfCreation}"/></label><br>
                    <label>Visitors: </label><label><c:out value="${place.subscribes}"/></label><br>

                    <c:forEach items="${place.tags}" var="tag">
                       <label id = "tags"> <c:out value="${tag}"/> </label>
                    </c:forEach>
                       </div>
                    <br>

                    <div hidden="hidden">
                        <form:input path="photo" value="${place.photo}"/> <br>
                        <form:input path="name" value="${place.name}"/> <br>
                        <form:input path="description" value="${place.description}"/> <br>
                        <form:input path="address" value="${place.address}"/> <br>
                        <form:input path="creatorEmail" value="${place.creatorEmail}"/> <br>
                        <form:input path="dateOfCreation" value="${place.dateOfCreation}"/> <br>
                        <form:input path="subscribes" value="${place.subscribes}"/> <br>
                        <form:input path="tags" value="${place.tags}"/> <br>
                        <form:input path="id" value="${place.id}"/> <br>
                    </div>
                    <button type="submit" name="place" >${action}</button>
                </div>
            </form:form>
        </div>
        </div>
        <div class="gap"></div>
        <jsp:include page="templates/footer.jsp" />

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
