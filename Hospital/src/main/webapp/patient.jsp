<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Patient Registration - Hospital</title>
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
            background: rgba(255, 255, 255, 0.85);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
            color: #000;
        }
    </style>
</head>
<body>

<div class="container mt-5 d-flex justify-content-center">
    <div class="form-container col-lg-8">
        <h2 class="text-center mb-4">Patient Registration</h2>

        <c:if test="${not empty message}">
            <div class="alert alert-success text-center">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>

        <form action="patientRegister" method="post">
            <div class="row g-4">
                <!-- Patient Details -->
                <div class="col-md-6">
                    <label for="patientName" class="form-label">Patient Name</label>
                    <input type="text" class="form-control" id="patientName" name="patientName"
                           value="${patient.patientName}" required>
                </div>

                <div class="col-md-6">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-select" id="gender" name="gender" required>
                        <option value="">-- Choose Gender --</option>
                        <option value="Male" ${patient.gender=='Male'?'selected':''}>Male</option>
                        <option value="Female" ${patient.gender=='Female'?'selected':''}>Female</option>
                        <option value="Others" ${patient.gender=='Others'?'selected':''}>Others</option>
                    </select>
                </div>

                <div class="col-md-6">
                    <label for="age" class="form-label">Age</label>
                    <input type="number" class="form-control" id="age" name="age" value="${patient.age}" required>
                </div>

                <div class="col-md-6">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                           value="${patient.phoneNumber}" required>
                </div>

                <div class="col-md-6">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${patient.email}" required>
                </div>

                <div class="col-md-6">
                    <label for="bloodGroup" class="form-label">Blood Group</label>
                    <select id="bloodGroup" name="bloodGroup" class="form-select" required>
                        <option value="">-- Select Blood Group --</option>
                        <c:forEach var="bg" items="${slotBloodGroups}">
                            <option value="${bg.bloodGroup}" ${patient.bloodGroup == bg.bloodGroup ? 'selected' : ''}>
                            ${bg.bloodGroup}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class="col-md-6">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address" value="${patient.address}" required>
                </div>

                <div class="col-12">
                    <label for="disease" class="form-label">Disease</label>
                    <textarea class="form-control" id="disease" name="disease" required>${patient.disease}</textarea>
                </div>

                <!-- Dynamic Selection -->
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

                <div class="col-12 text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function fetchDoctorsAndSlots() {
    var specSelect = document.getElementById("specialisation");
    var doctorSelect = document.getElementById("doctor");
    var slotSelect = document.getElementById("slot");
    var doctorSlotsMap = {};

    specSelect.addEventListener("change", function() {
        var spec = specSelect.value;
        doctorSelect.innerHTML = '<option value="">-- Select Doctor --</option>';
        slotSelect.innerHTML = '<option value="">-- Select Slot --</option>';
        doctorSlotsMap = {};

        if (!spec) return;

        var xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/api/fetchDoctorAndSlots/" + encodeURIComponent(spec), true);
        xhttp.send();

        xhttp.onload = function() {
            if (xhttp.status === 200) {
                try {
                    var data = JSON.parse(xhttp.responseText);
                    var doctorMap = {};
                    console.log(data)
                    data.forEach(function(slotDTO) {
                        var docId = slotDTO.doctorId;
                        if (!doctorMap[docId]) doctorMap[docId] = slotDTO.doctorName;

                        if (!doctorSlotsMap[docId]) doctorSlotsMap[docId] = [];
                        doctorSlotsMap[docId].push({ id: slotDTO.id, timeSlot: slotDTO.timeSlot });
                    });

                    // populate doctor dropdown
                    for (var id in doctorMap) {
                        var option = document.createElement("option");
                        option.value = id;
                        option.textContent = doctorMap[id];
                        doctorSelect.appendChild(option);
                    }
                } catch (e) {
                    console.error("Error parsing JSON: ", e, xhttp.responseText);
                }
            } else {
                console.error("Error fetching doctors: " + xhttp.status);
            }
        };
    });

    doctorSelect.addEventListener("change", function() {
        var docId = doctorSelect.value;
        slotSelect.innerHTML = '<option value="">-- Select Slot --</option>';

        if (!docId || !doctorSlotsMap[docId]) return;

        doctorSlotsMap[docId].forEach(function(slot) {
            var option = document.createElement("option");
            option.value = slot.id;
            option.text = slot.timeSlot;
            slotSelect.add(option);
        });
    });
}

document.addEventListener("DOMContentLoaded", fetchDoctorsAndSlots);

</script>



</body>
</html>
