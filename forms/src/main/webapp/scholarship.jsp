<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Scholarship Application</title>
    <style>.error { color: red; font-size: 14px; }</style>
</head>
<body>
<h2>Scholarship Application Form</h2>

<form:form method="post" action="scholarship" modelAttribute="scholarshipDTO">

    <div>
        <form:label path="studentName">Student Name:</form:label>
        <form:input path="studentName"/>
        <form:errors path="studentName" cssClass="error"/>
    </div>

    <div>
        <form:label path="course">Course:</form:label>
        <form:input path="course"/>
        <form:errors path="course" cssClass="error"/>
    </div>

    <div>
        <form:label path="marks">Marks:</form:label>
        <form:input path="marks"/>
        <form:errors path="marks" cssClass="error"/>
    </div>

    <div>
        <form:label path="income">Family Income:</form:label>
        <form:input path="income"/>
        <form:errors path="income" cssClass="error"/>
    </div>

    <div>
        <input type="submit" value="Apply"/>
    </div>

</form:form>
</body>
</html>
