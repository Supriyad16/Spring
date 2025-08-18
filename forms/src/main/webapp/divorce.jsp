<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Divorce Application</title>
    <style>.error { color: red; font-size: 14px; }</style>
</head>
<body>
<h2>Divorce Application Form</h2>

<form:form method="post" action="divorce" modelAttribute="divorceDTO">

    <div>
        <form:label path="husbandName">Husband Name:</form:label>
        <form:input path="husbandName"/>
        <form:errors path="husbandName" cssClass="error"/>
    </div>

    <div>
        <form:label path="wifeName">Wife Name:</form:label>
        <form:input path="wifeName"/>
        <form:errors path="wifeName" cssClass="error"/>
    </div>

    <div>
        <form:label path="marriageDate">Marriage Date:</form:label>
        <form:input path="marriageDate"/>
        <form:errors path="marriageDate" cssClass="error"/>
    </div>

    <div>
        <form:label path="reason">Reason:</form:label>
        <form:textarea path="reason" rows="3" cols="30"/>
        <form:errors path="reason" cssClass="error"/>
    </div>

    <div>
        <form:label path="court">Court Name:</form:label>
        <form:input path="court"/>
        <form:errors path="court" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Submit"/>
    </div>
</form:form>
</body>
</html>
