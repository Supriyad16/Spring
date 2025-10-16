<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <title>Slot Allotment</title>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: url('images/time.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px; /* space for fixed navbar */
            color: #fff;
        }
    </style>
</head>

<body>


<nav class="navbar navbar-dark bg-dark py-3 fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="Doctor" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>


<div class="offcanvas offcanvas-end bg-dark text-white" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item"><a class="nav-link text-white" href="dashboard.jsp"><b>Home</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Specialisation</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="check"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="slot"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="disp"><b>Add Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="DoctorList"><b>Update Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patient"><b>Patient</b></a></li>



            <li class="nav-item mt-3"><a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a></li>
        </ul>
    </div>
</div>

<div class="container mt-5">
    <h2 class="text-center mb-4" style="color:black;">Specialisation</h2>

    <div class="card shadow col-md-5 mx-auto">
        <div class="card-body">
            <form action="specialisation" method="post">

                <div class="mb-3">
                <label for="specialisation" class="form-label" style="color:black;"><b>Specialisation</b></label>
                <input type="text" class="form-control" id="specialisation" name="specialisation"
                       oninput="validateName()" onkeypress="return onlyLetters(event)" required placeholder="Add Specialisation">
                <span id="doctorNameError" style="color:red;"></span>
        </div>

                <!-- Submit Button -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Save </button>
                </div>

            </form>
        </div>
    </div>

    <!-- Success message -->
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center mt-3 col-md-5 mx-auto">${message}</div>
    </c:if>
</div>


</body>
</html>
