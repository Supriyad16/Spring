<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Patient Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">Registered Patient Details</h2>

    <c:if test="${not empty patientList}">
        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
            <tr>
                <th>Patient ID</th>
                <th>Registration ID</th>
                <th>Name</th>
                <th>Specialisation</th>
                <th>Doctor Name</th>
                <th>Slot Time</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Age</th>
                <th>Blood Group</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${patientList}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.registrationId}</td>
                    <td>${p.patientName}</td>
                    <td>${p.specialisation}</td>
                    <td>${p.doctorName}</td>
                    <td>${p.slot}</td>
                    <td>${p.email}</td>
                    <td>${p.phoneNumber}</td>
                    <td>${p.age}</td>
                    <td>${p.bloodGroup}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty patientList}">
        <div class="alert alert-warning text-center">
            No patient records found.
        </div>
    </c:if>

    <div class="text-center mt-4">
        <a href="patientList" class="btn btn-primary">Back</a>
    </div>
</div>

</body>
</html>
