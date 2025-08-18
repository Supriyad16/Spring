<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Loan Application</title>
    <style>
        .error { color: red; font-size: 14px; }
    </style>
</head>
<body>
<h2>Loan Application Form</h2>

<form:form method="post" action="loan" modelAttribute="loanDTO">

    <div>
        <form:label path="applicantName">Applicant Name:</form:label>
        <form:input path="applicantName"/>
        <form:errors path="applicantName" cssClass="error"/>
    </div>

    <div>
        <form:label path="amount">Loan Amount:</form:label>
        <form:input path="amount"/>
        <form:errors path="amount" cssClass="error"/>
    </div>

    <div>
        <form:label path="purpose">Purpose:</form:label>
        <form:textarea path="purpose" rows="3" cols="30"/>
        <form:errors path="purpose" cssClass="error"/>
    </div>

    <div>
        <form:label path="phoneNumber">Phone Number:</form:label>
        <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Apply"/>
    </div>

</form:form>

</body>
</html>
