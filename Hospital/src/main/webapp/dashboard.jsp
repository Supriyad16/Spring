<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Admin Dashboard - Hospital</title>

    <nav class="navbar navbar-dark bg-dark py-3">
        <div class="container-fluid">
            <a class="navbar-brand fs-4" href="#">
                <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
                Sushrutha Chikitsalaya
            </a>
            <form class="d-flex">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg">Logout</a>
            </form>
        </div>
    </nav>

</head>
<body class="bg-light">

<div class="container mt-5">

    <c:if test="${not empty message}">
        <div class="alert alert-success text-center">${message}</div>
    </c:if>

    <h2 class="mb-4 text-center">Welcome, Admin</h2>

</div>

</body>
</html>
