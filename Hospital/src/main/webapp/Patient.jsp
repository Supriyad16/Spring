<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Doctor Registration - Hospital</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="validation.js"></script>
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
            <li class="nav-item"><a class="nav-link text-white" href="schedule.jsp"><b>Schedule</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="addSlots"><b>Add Slots</b></a></li>
            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<div class="container mt-5 d-flex justify-content-center">
    <div class="form-container col-lg-8">
        <h2 class="text-center mb-4">Patient Registration</h2>

        <form class="row g-4" action="doctor" method="post">

            <div class="col-md-6">
                <label for="patientName" class="form-label">Patient Name</label>
                <input type="text" class="form-control" id="patientName" name="patientName"
                       oninput="validatePatientName()" onkeypress="return onlyLetters(event)" required>
                <span id="patientNameError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="gender" class="form-label">Gender</label>

                <select id="gender" name="gender" class="form-select" required oninput="validateGender()">
                    <span id="genderError" style="color:red;"></span>
                    <option selected disabled>Choose Gender</option>
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

            <div class="col-md-6">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" onkeypress="return onlyNumbers(event)" required oninput="validatePhoneNo()">
                <span id="phoneError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required oninput="validateEmail()">
                <span id="emailError" style="color:red;"></span>
            </div>

            <div class="col-md-6">
                <label for="blood" class="form-label">Blood Group</label>

                <select id="blood" name="blood" class="form-select" required >

                    <option selected disabled>Choose Blood Group</option>
                    <option value="a+">A +ve</option>
                    <option value="a-">A -ve</option>
                    <option value="b+">B +ve</option>
                    <option value="b-">B -ve</option>
                    <option value="ab+">AB +ve</option>
                    <option value="ab-">AB -ve</option>
                    <option value="o+">O +ve </option>
                    <option value="o-">O -ve</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="disease" class="form-label" style="color:black;">Disease</label>
                <textarea name="address" class="form-control" id="disease" name="disease" placeholder="Describe the Disease"
                          onkeypress="return onlyLetters(event)" required></textarea>
            </div>

            <div class="col-md-6">
                <label for="specialisation" class="form-label">Specialisation</label>
                <select class="form-select" id="specialisation" name="specialisation" required>
                    <option value="">-- Select Specialisation --</option>
                    <c:forEach var="doc" items="${doctors}">
                        <option value="${doc.id}">${doc.specialisation}</option>
                    </c:forEach>

                </select>
            </div>

            <div class="col-md-6">
                <label for="doctorName" class="form-label">Select Doctor</label>
                <select class="form-select" id="doctorName" name="doctorName" required>
                    <option value="">-- Select Doctor --</option>
                    <c:forEach var="doc" items="${doctors}">
                        <option value="${doc.id}">${doc.doctorName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6">
                <label for="slot" class="form-label" >Select Slot</label>
                <select class="form-select" id="slot" name="slot" required>
                    <option value="">-- Select Slot --</option>
                    <c:forEach var="s" items="${slots}">
                        <option value="${s.id}">${s.fromTime} - ${s.toTime}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-12 text-center mt-4">
                <button type="submit" class="btn btn-primary px-5">Save</button>
            </div>
        </form>
    </div>
</div>


</body>
</html>

