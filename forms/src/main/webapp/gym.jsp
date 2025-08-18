<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Gym Membership</title>
    <style>.error { color: red; font-size: 14px; }</style>
</head>
<body>
<h2>Gym Membership Form</h2>

<form:form method="post" action="gym" modelAttribute="gymDTO">

    <div>
        <form:label path="memberName">Member Name:</form:label>
        <form:input path="memberName"/>
        <form:errors path="memberName" cssClass="error"/>
    </div>

    <div>
        <form:label path="age">Age:</form:label>
        <form:input path="age"/>
        <form:errors path="age" cssClass="error"/>
    </div>

    <div>
        <form:label path="plan">Plan:</form:label>
        <form:select path="plan">
            <form:option value="Monthly" label="Monthly"/>
            <form:option value="Quarterly" label="Quarterly"/>
            <form:option value="Yearly" label="Yearly"/>
        </form:select>
        <form:errors path="plan" cssClass="error"/>
    </div>

    <div>
        <form:label path="phone">Phone:</form:label>
        <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/>
    </div>

    <div>
        <form:label path="trainer">Personal Trainer (Yes/No):</form:label>
        <form:input path="trainer"/>
        <form:errors path="trainer" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Join"/>
    </div>
</form:form>
</body>
</html>
