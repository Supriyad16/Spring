<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Marriage Registration</title>
    <style>.error { color: red; font-size: 14px; }</style>
</head>
<body>
<h2>Marriage Registration Form</h2>

<form:form method="post" action="marriage" modelAttribute="marriageDTO">

    <div>
        <form:label path="brideName">Bride Name:</form:label>
        <form:input path="brideName"/>
        <form:errors path="brideName" cssClass="error"/>
    </div>

    <div>
        <form:label path="groomName">Groom Name:</form:label>
        <form:input path="groomName"/>
        <form:errors path="groomName" cssClass="error"/>
    </div>

    <div>
        <form:label path="date">Marriage Date:</form:label>
        <form:input path="date" type="date"/>
        <form:errors path="date" cssClass="error"/>
    </div>

    <div>
        <form:label path="place">Marriage Place:</form:label>
        <form:input path="place"/>
        <form:errors path="place" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Register"/>
    </div>

</form:form>
</body>
</html>
