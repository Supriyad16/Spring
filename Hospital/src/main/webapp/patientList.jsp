<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Patient Details - Hospital</title>

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
            <li class="nav-item"><a class="nav-link text-white" href="Specialisation.jsp"><b>Specialisation</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="slot"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="disp"><b>Add Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="DoctorList"><b>Update Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patient"><b>Patient</b></a></li>


            <li class="nav-item mt-3">
                <a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a>
            </li>
        </ul>
    </div>
</div>

<div class="container mt-5 d-flex justify-content-center">
    <div class="form-container col-lg-8">
        <h2 class="text-center mb-4">Patient Details</h2>

        <form action="patientDetails" method="post">
            <div class="col-md-4">
                <label for="specialisation" class="form-label">Specialisation</label>
                <select id="specialisation" name="specialisation" class="form-select" required>
                    <option value="">-- Select Specialisation --</option>
                    <c:forEach var="spec" items="${slotSpecialisations}">
                        <option value="${spec.specialisation}">${spec.specialisation}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-4">
                <label for="doctor" class="form-label">Doctor</label>
                <select id="doctor" name="doctorId" class="form-select" required>
                    <option value="">-- Select Doctor --</option>
                </select>
            </div>

            <div class="col-md-4">
                <label for="slot" class="form-label">Time Slot</label>
                <select id="slot" name="slotId" class="form-select" required>
                    <option selected disabled>-- Select Slot --</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">Submit</button>
        </form>

        <!-- jQuery (required for AJAX) -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
    document.getElementById("specialisation").addEventListener("change", function() {
    let specialisation = this.value;
    let doctorSelect = document.getElementById("doctor");
    let slotSelect = document.getElementById("slot");

    console.log("Selected Specialisation:", specialisation);

    doctorSelect.innerHTML = "<option value=''>-- Select Doctor --</option>";
    slotSelect.innerHTML = "<option value=''>-- Select Slot --</option>";

    if (!specialisation) return;

    <!--*-*-*-*-->

    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/Hospital/api/patientList/fetchDoctorList/" + specialisation, true);
    xhr.onload = function () {
        console.log("Doctor API response:", xhr.responseText);
        if (xhr.status === 200) {
            let response = xhr.responseText.trim();
            if (response && response !== "No Doctors Found" && response !== "No doctors") {
                let doctors = response.split(",");
                doctors.forEach(function (doc) {
                    let parts = doc.split("|");
                    let option = document.createElement("option");
                    option.value = parts[1];  // doctorId
                    option.text = parts[0];   // doctorName
                    doctorSelect.add(option);
                });
            }
        }
    };
    xhr.send();
});

// When doctor changes, fetch slots
document.getElementById("doctor").addEventListener("change", function() {
    let doctorId = this.value;
    let slotSelect = document.getElementById("slot");
    slotSelect.innerHTML = "<option value=''>-- Select Slot --</option>";

    if (!doctorId) return;

<!--*-*-*-->
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "http://localhost:8080/Hospital/api/patientList/fetchTimeSlotList?id=" + doctorId, true);
    xhr.onload = function () {
        console.log("TimeSlot API response:", xhr.responseText);
        if (xhr.status === 200) {
            let response = xhr.responseText.trim();
            if (response && response !== "Not Assigned") {
                let slots = response.split("|");
                slots.forEach(function (s) {
                    let parts = s.split(",");
                    let option = document.createElement("option");
                    option.value = parts[1];  // slotId
                    option.text = parts[0];   // timeSlot
                    slotSelect.add(option);
                });
            }
        }
    };
    xhr.send();
});

      </script>
    </div>
</div>
</body>
</html>
