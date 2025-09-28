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
            padding-top: 80px;
            color: #333;
        }

        .navbar-brand img {
            border-radius: 50%;
        }

        .card {
            border-radius: 1rem;
        }

        .card h5 {
            font-weight: bold;
        }

        .btn-primary {
            background-color: #007bff;
            border: none;
        }

        .form-select:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(0,123,255,.25);
        }

        .offcanvas {
            width: 250px;
        }

        .card-shadow {
            box-shadow: 0 0.5rem 1rem rgba(0,0,0,0.15);
        }
    </style>
</head>

<body>

<nav class="navbar navbar-dark bg-dark py-3 fixed-top shadow">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="Doctor" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar">
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
            <li class="nav-item"><a class="nav-link text-white" href="addSlots"><b>Add Slots</b></a></li>
            <li class="nav-item mt-3"><a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a></li>
        </ul>
    </div>
</div>

<div class="container mt-5">
    <h2 class="text-center mb-5" style="color:black;">Slot Allotment</h2>

    <!-- Display success or error messages -->
    <c:if test="${not empty success}">
        <div class="alert alert-success alert-dismissible fade show text-center" role="alert">
            ${success}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger alert-dismissible fade show text-center" role="alert">
            ${error}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>

    <div class="card shadow card-shadow col-md-5 mx-auto mb-5">
        <div class="card-body p-5">
            <form action="addSlots" method="post">
                <div class="mb-4">
                    <h5 class="text-center mb-3" style="color:black;">Select Specialisation</h5>
                    <select id="specialisation" name="specialisation" class="form-select" required>
                        <option value="">Select Specialisation</option>
                        <c:forEach var="spec" items="${slotSpecialisations}">
                            <option value="${spec.specialisation}">
                                <c:if test="${specialisation eq spec.specialisation}">selected</c:if>
                                ${spec.specialisation}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Submit</button>
                </div>
            </form>
        </div>
    </div>

    <c:if test="${not empty openDoctorForm}">
        <div class="card shadow card-shadow col-md-6 mx-auto">
            <div class="card-body p-5">
                <h5 class="mb-4 text-center">Assign Doctor & Slot</h5>
                <form action="assignSlot" method="post">
                    <input type="hidden" name="specialisation" value="${specialisation}">

                    <div class="mb-3">
                        <label for="doctor" class="form-label">Doctor:</label>
                        <select id="doctor" name="doctorId" class="form-select" required>
                            <option value="">-- Select Doctor --</option>
                            <c:forEach var="doc" items="${doctors}">
                                <option value="${doc.id}">${doc.doctorName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="slot" class="form-label">Slot:</label>
                        <select id="slot" name="slotId" class="form-select" required>
                            <option value="">-- Select Slot --</option>
                            <c:forEach var="slot" items="${slots}">
                                <option value="${slot.id}">${slot.fromTime} - ${slot.toTime}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary w-100">Assign Slot</button>
                </form>
            </div>
        </div>
    </c:if>
</div>

</body>
</html>
