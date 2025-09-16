<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Doctor Save Result</title>
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark mb-4 py-3">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya - Admin Dashboard
        </a>
        <form class="d-flex">
            <a href="admin.jsp" class="btn btn-outline-light btn-lg">Logout</a>
        </form>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <!-- Result Card -->
            <div class="card shadow-lg rounded-3">
                <div class="card-body">

                    <!-- Success / Failure Message -->
                    <h4 class="card-title text-center mb-4 text-primary">
                        ${message}
                    </h4>

                    <!-- Show doctor details only if saved successfully -->
                    <c:if test="${not empty doctor}">
                        <table class="table table-bordered table-striped">
                            <tr>
                                <th>Doctor Name</th>
                                <td>${doctor.doctorName}</td>
                            </tr>
                            <tr>
                                <th>Specialisation</th>
                                <td>${doctor.specialisation}</td>
                            </tr>
                            <tr>
                                <th>Qualification</th>
                                <td>${doctor.qualification}</td>
                            </tr>
                            <tr>
                                <th>Experience</th>
                                <td>${doctor.experience}</td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td>${doctor.email}</td>
                            </tr>
                            <tr>
                                <th>Phone Number</th>
                                <td>${doctor.phoneNumber}</td>
                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>${doctor.gender}</td>
                            </tr>
                            <tr>
                                <th>Age</th>
                                <td>${doctor.age}</td>
                            </tr>
                            <tr>
                                <th>Available Days</th>
                                <td>${doctor.availableDays}</td>
                            </tr>
                            <tr>
                                <th>Available Time</th>
                                <td>${doctor.availableTime}</td>
                            </tr>

                        </table>
                    </c:if>

                    <div class="text-center mt-4">
                        <a href="doctorForm.jsp" class="btn btn-success px-4">Add Another Doctor</a>
                        <a href="adminDashboard.jsp" class="btn btn-secondary px-4">Back to Dashboard</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
