<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>
<body>
<H1>
    Sign Up
</H1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <br>
    <tr>
        <td><label>
            First Name
        </label>
        </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <br>
    <tr>
        <td>
            <label>
                Last Name
        </label>
        </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <br>
    <tr>
        <td><label>E-mail
        </label>
        </td>
        <td><form:input path="email" value="" /></td>
        <%--<form:errors path="email" element="div" />--%>
    </tr>
    <br>
    <tr>
        <td><label>Password
        </label>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <br>
    <tr>
        <td><label>Confirm Password
        </label>
        </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    <br>
    <button type="submit">Submit
    </button>
</form:form>
<br>
<a href="<c:url value="login.jsp" />">

</a>
</body>
</html>