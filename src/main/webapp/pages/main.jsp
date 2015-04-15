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
</head>
<body>
    <sec:authorize access="isAuthenticated()">
         <a href='/travelit/profile' >Profile</a>
         <a href='/travelit/places' >Places</a>
         <a href='/travelit/achievements' >Achievements</a>
         <a href='<c:url value="/logout" />' >Log out</a>
        <p>E-mail: <sec:authentication property="principal.username" /></p>

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
