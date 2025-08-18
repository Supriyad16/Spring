<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns:form="http://www.w3.org/1999/xhtml" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <title>Dance Registration</title>
    <style>
        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>
<h2>Dance Registration Form</h2>

<!-- Binding to danceDTO -->
<form:form method="post" action="dance" modelAttribute="danceDTO">

    <div>
        <form:label path="name">Name:</form:label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" />
    </div>

    <div>
        <form:label path="age">Age:</form:label>
        <form:input path="age" />
        <form:errors path="age" cssClass="error" />
    </div>

    <div>
        <form:label path="danceType">Dance Type:</form:label>
        <form:input path="danceType" />
        <form:errors path="danceType" cssClass="error" />
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" />
    </div>

    <div>
        <form:label path="amount">Amount (₹):</form:label>
        <form:input path="amount" />
        <form:errors path="amount" cssClass="error" />
    </div>

    <div>
        <input type="submit" value="Register"/>
    </div>

</form:form>

<!-- Display global errors if any -->
<c:if test="${not empty errors}">
    <div class="error">
        <c:forEach var="err" items="${errors}">
            <p>${err.defaultMessage}</p>
        </c:forEach>
    </div>
</c:if>

</body>
</html>
