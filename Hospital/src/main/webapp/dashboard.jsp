<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Dashboard - Hospital</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: url('images/background.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px; /* space for navbar */
            color: #fff;
        }

        .navbar-brand img {
            border-radius: 50%;
        }

        .container h2 {
            font-weight: bold;
            text-shadow: 1px 1px 4px rgba(0,0,0,0.7);
        }

        .offcanvas-body a.nav-link:hover {
            background-color: rgba(255,255,255,0.2);
            border-radius: 5px;
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
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

<c:if test="${not empty message}">
    <div class="alert alert-info">${message}</div>
</c:if>

<!-- Offcanvas Menu -->
<div class="offcanvas offcanvas-end bg-dark text-white" tabindex="-1" id="offcanvasNavbar"
     aria-labelledby="offcanvasNavbarLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"
                aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Home</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="Specialisation.jsp"><b>Specialisation</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="check"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="slot"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="disp"><b>Add Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="DoctorList"><b>Update Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patient"><b>Patient</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patientList"><b>Patient List</b></a></li>


            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<!-- Main Content -->
<div class="container mt-5 text-center">


    <h2>Welcome, Admin</h2>
</div>

</body>
</html>
