<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Doctor List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2>Doctors</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Specialisation</th>
            <th>Qualification</th>
            <th>Experience</th>
            <th>Phone</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="doc" items="${doctors}">
            <tr>
                <td>${doc.doctorName}</td>
                <td>${doc.email}</td>
                <td>${doc.specialisation}</td>
                <td>${doc.qualification}</td>
                <td>${doc.experience}</td>
                <td>${doc.phoneNumber}</td>
                <td>${doc.age}</td>
                <td>
                    <!-- Update button -->
                    <a href="UpdateDoctor?email=${doc.email}" class="btn btn-sm btn-warning">
                        Update
                    </a>
                    <!-- Delete button -->
                    <a href="delete?email=${doc.email}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this doctor?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>


