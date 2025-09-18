<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Doctor Registration - Hospital</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: url('images/sthethoscope.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px; /* space for navbar */
            color: #fff;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.85);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
            color: #000;
        }

        .navbar-brand img {
            border-radius: 50%;
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

<!-- Offcanvas Menu -->
<div class="offcanvas offcanvas-end bg-dark text-white" tabindex="-1" id="offcanvasNavbar"
     aria-labelledby="offcanvasNavbarLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item"><a class="nav-link text-white" href="dashboard.jsp"><b>Home</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="slot.jsp"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="addSlots"><b>Add Slots</b></a></li>
            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<div class="container mt-5 d-flex justify-content-center">
    <div class="form-container col-lg-8">
        <h2 class="text-center mb-4">Doctor Registration</h2>

        <form class="row g-4" action="doctor" method="post">

            <div class="col-md-6">
                <label for="doctorName" class="form-label">Doctor Name</label>
                <input type="text" class="form-control" id="doctorName" name="doctorName"
                       onkeypress="return onlyLetters(event)" oninput="validateName()" required>
                <span id="doctorNameError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="specialisation" class="form-label">Specialisation</label>
                <input type="text" class="form-control" id="specialisation" name="specialisation" required>
            </div>

            <div class="col-md-6">
                <label for="qualification" class="form-label">Qualification</label>
                <input type="text" class="form-control" id="qualification" name="qualification" required>
            </div>

            <div class="col-md-6">
                <label for="experience" class="form-label">Experience</label>
                <input type="text" class="form-control" id="experience" name="experience" placeholder="in years" required>
            </div>

            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required oninput="validateEmail()">
                <span id="emailError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required oninput="validatePhoneNo()">
                <span id="phoneError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="gender" class="form-label">Gender</label>

                <select id="gender" name="gender" class="form-select" required oninput="validateGender()">
                    <span id="genderError" style="color:red;"></span>
                    <option selected disabled>Choose...</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Others">Others</option>
                </select>
            </div>

            <div class="col-md-6">
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" id="age" name="age" required oninput="validateAge()">
                <span id="ageError" style="color:red;"></span>
            </div>

            <div class="col-12" >
                <label class="form-label">Available Days</label><br>
                <div class="form-check form-check-inline" >
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Monday">
                    <label class="form-check-label">Monday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Tuesday">
                    <label class="form-check-label">Tuesday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Wednesday">
                    <label class="form-check-label">Wednesday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Thursday">
                    <label class="form-check-label">Thursday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Friday">
                    <label class="form-check-label">Friday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Saturday">
                    <label class="form-check-label">Saturday</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="availableDays" value="Sunday">
                    <label class="form-check-label">Sunday</label>
                </div>
            </div>

            <div class="col-12 text-center mt-4">
                <button type="submit" class="btn btn-primary px-5">Save</button>
            </div>
        </form>
    </div>
</div>
<script src="validate.js"></script>
</body>
</html>
