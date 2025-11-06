<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Slot Allotment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            margin: 0;
            min-height: 100vh;
            background: url('images/time.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px;
        }

        .card {
            border-radius: 15px;
        }

        .alert {
            font-weight: bold;
        }
    </style>


    <script>
        function CheckTimeSlot() {
        console.log("CheckTimeSlot called");
    let specialisation = document.getElementById("specialisation").value;
    let fromHour = document.getElementById("fromHour").value;
    let fromMinute = document.getElementById("fromMinute").value;
    let fromAmPm = document.getElementById("fromAmPm").value;
    let toHour = document.getElementById("toHour").value;
    let toMinute = document.getElementById("toMinute").value;
    let toAmPm = document.getElementById("toAmPm").value;

    let message = document.getElementById("warningMsg");
    let saveBtn = document.querySelector("#slotForm button[type='submit']");

    let fromTime = fromHour + ":" + (fromMinute.length === 1 ? "0" + fromMinute : fromMinute) + " " + fromAmPm;
    let toTime = toHour + ":" + (toMinute.length === 1 ? "0" + toMinute : toMinute) + " " + toAmPm;

    message.style.display = "none";
    saveBtn.disabled = false;

console.log("Solt controller");
<!--    if (!specialisation || !fromHour || !fromMinute || !toHour || !toMinute) return;-->

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            const response = this.responseText.trim();
            if (response === "exists") {
                message.style.display = "block";
                saveBtn.disabled = true;
            } else {
                message.style.display = "none";
                saveBtn.disabled = false;
            }
        }
    };

    xhttp.open("POST", "${pageContext.request.contextPath}/api/slot/checkDuplicate", true);
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send(
    "specialisation=" + encodeURIComponent(specialisation) +
    "&fromTime=" + encodeURIComponent(fromTime) +
    "&toTime=" + encodeURIComponent(toTime)
);
console.log("Calling duplicate slot API with:", specialisation, fromTime, toTime);

}

    </script>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark py-3 fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="Doctor" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<!-- Offcanvas Menu -->
<div class="offcanvas offcanvas-end bg-dark text-white" tabindex="-1" id="offcanvasNavbar">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
            <li class="nav-item"><a class="nav-link text-white" href="dashboard.jsp"><b>Home</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="Specialisation.jsp"><b>Specialisation</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="check"><b>Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="#"><b>Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="disp"><b>Add Slots</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="DoctorList"><b>Update Doctor</b></a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patient"><b>Patient</b></a></li>
            <li class="nav-item mt-3"><a href="admin.jsp" class="btn btn-outline-light btn-lg w-100">Logout</a></li>
            <li class="nav-item"><a class="nav-link text-white" href="patientList"><b>Patient List</b></a></li>

        </ul>
    </div>
</div>

<!-- Main Container -->
<div class="container mt-5 pt-4">
    <h2 class="text-center mb-4 text-dark">Slot Allotment</h2>

    <div class="card shadow col-md-6 mx-auto">
        <div class="card-body">
            <form id="slotForm" action="slot" method="post">

                <!-- Specialisation -->
                <div class="mb-3">
                    <label class="form-label text-dark"><strong>Specialisation</strong></label>
                    <select class="form-select" id="specialisation" name="specialisation" onchange="CheckTimeSlot()" required>
                        <option value="">-- Select Specialisation --</option>
                        <c:forEach var="doc" items="${doctors}">
                            <option value="${doc.id}">${doc.specialisation}</option>
                        </c:forEach>
                    </select>
                </div>

                <!-- From Time -->
                <div class="mb-3">
                    <label class="form-label text-dark"><strong>From Time</strong></label>
                    <div class="input-group">
                        <select class="form-select" id="fromHour" name="fromHour" onchange="CheckTimeSlot()" required>
                            <option value="">Hour</option>
                            <c:forEach var="h" begin="1" end="12"><option>${h}</option></c:forEach>
                        </select>
                        <span class="input-group-text">:</span>
                        <select class="form-select" id="fromMinute" name="fromMinute" onchange="CheckTimeSlot()" required>
                            <option value="">Min</option>
                            <c:forEach var="m" begin="0" end="59">
                                <option><c:out value="${m < 10 ? '0' + m : m}"/></option>
                            </c:forEach>
                        </select>
                        <select class="form-select" id="fromAmPm" name="fromAmPm" onchange="CheckTimeSlot()">
                            <option>AM</option>
                            <option>PM</option>
                        </select>
                    </div>
                </div>

                <!-- To Time -->
                <div class="mb-3">
                    <label class="form-label text-dark"><strong>To Time</strong></label>
                    <div class="input-group">
                        <select class="form-select" id="toHour" name="toHour" onchange="CheckTimeSlot()" required>
                            <option value="">Hour</option>
                            <c:forEach var="h" begin="1" end="12"><option>${h}</option></c:forEach>
                        </select>
                        <span class="input-group-text">:</span>
                        <select class="form-select" id="toMinute" name="toMinute" onchange="CheckTimeSlot()"required>
                            <option value="">Min</option>
                            <c:forEach var="m" begin="0" end="59">
                                <option><c:out value="${m < 10 ? '0' + m : m}"/></option>
                            </c:forEach>
                        </select>
                        <select class="form-select" id="toAmPm" name="toAmPm" onchange="CheckTimeSlot()">
                            <option>AM</option>
                            <option>PM</option>
                        </select>
                    </div>
                </div>

                <!-- Warning Message -->
                <div id="warningMsg" class="alert alert-danger text-center" style="display:none;">
                    ⚠️ Time slot already exists for this specialisation!
                </div>

                <!-- Submit Button -->
                <div class="text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Save Slot</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Success Message -->
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center mt-3 col-md-6 mx-auto">${message}</div>
    </c:if>
</div>

</body>
</html>

