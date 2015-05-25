<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title></title>
</head>
<body>
    <sec:authorize access="isAuthenticated()">
        <jsp:include page="templates/upperMenuTempl.jsp"  />
        <h1>Achievements</h1>
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
