<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Doctor Registration - Hospital</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: url('images/sthethoscope.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px;
            color: #fff;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
            color: #000;
        }
        .navbar-brand img {
            border-radius: 50%;
        }
        .table thead {
            background-color: #343a40;
            color: #fff;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark fixed-top py-3">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="Logo" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<!-- Sidebar Menu -->
<div class="offcanvas offcanvas-end bg-dark text-white" tabindex="-1" id="offcanvasNavbar"
     aria-labelledby="offcanvasNavbarLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item"><a class="nav-link text-white" href="dashboard.jsp"><b>Home</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="Specialisation.jsp"><b>Specialisation</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="check"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="slot"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="disp"><b>Add Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Update Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patient"><b>Patient</b></a></li>

            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<!-- Main Content -->
<div class="container mt-5">
    <div class="form-container">
        <h2 class="mb-4 text-center">Doctors List</h2>

        <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered align-middle">
                <thead class="text-center">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Specialisation</th>
                    <th>Qualification</th>
                    <th>Experience</th>
                    <th>Phone</th>
                    <th>Age</th>
                    <th>Images</th>
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
                        <td class="text-center">
                            <c:choose>
                                <c:when test="${not empty doc.imagePath}">
                                    <img src="download?imagePath=${doc.imagePath}"
                                         alt="Profile"
                                         class="img-fluid rounded-circle"
                                         style="width: 60px; height: 60px; object-fit: cover;"/>
                                </c:when>
                                <c:otherwise>
                                    <span class="text-muted">No Image</span>
                                </c:otherwise>
                            </c:choose>
                        </td>


                        <td class="text-center">
                            <a href="UpdateDoctor?email=${doc.email}" class="btn btn-sm btn-warning me-2">
                                <i class="bi bi-pencil-square"></i> Update
                            </a>
                            <a href="delete?email=${doc.email}"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Are you sure you want to delete this doctor?');">
                                <i class="bi bi-trash"></i> Delete
                            </a>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">

</body>
</html>
