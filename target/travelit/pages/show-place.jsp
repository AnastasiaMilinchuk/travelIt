<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <form:form modelAttribute="place" method="POST" enctype="utf8">
        <img style="width: 20%;" src='<c:url value="${place.photo}"/>' /><br>
        <label><c:out value="${place.address}"/></label><br>
        <label><c:out value="${place.creatorEmail}"/></label><br>
        <label><c:out value="${place.dateOfCreation}"/></label><br>
        <label><c:out value="${place.subscribes}"/></label><br>
        <label>Tags:</label><br>
        <c:forEach items="${place.tags}" var="tag">
           <label> <c:out value="${tag}"/> </label>
        </c:forEach>
        <br>


            <form:input path="photo" value="${place.photo}"/> <br>
            <form:input path="name" value="${place.name}"/> <br>
            <form:input path="describtion" value="${place.describtion}"/> <br>
            <form:input path="address" value="${place.address}"/> <br>
            <form:input path="creatorEmail" value="${place.creatorEmail}"/> <br>
            <form:input path="dateOfCreation" value="${place.dateOfCreation}"/> <br>
            <form:input path="subscribes" value="${place.subscribes}"/> <br>
            <form:input path="tags" value="${place.tags}"/> <br>
            <form:input path="id" value="${place.id}"/> <br>

            <button type="submit" name="place" >Subscribe</button>
        </form:form>

    </div>
</body>
</html>
