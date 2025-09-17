<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Admin Dashboard - Hospital</title>
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark py-3">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
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
            <li class="nav-item">
                <a class="nav-link text-white" href="index.jsp"><b>Home</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="doctor.jsp"><b>Doctor</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="slot.jsp"><b>Slots</b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-white" href="addSlots.jsp"><b>Add Slots</b></a>
            </li>
            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<div class="container mt-5">
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>

    <h2 class="mb-4 text-center">Welcome, Admin</h2>
</div>

</body>
</html>
