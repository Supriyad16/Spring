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

        <form action="patient" method="post">
            <div class="row g-4">
                <!-- Patient Details -->
                <div class="col-md-6">
                    <label for="patientName" class="form-label">Patient Name</label>
                    <input type="text" class="form-control" id="patientName" name="patientName"
                           value="${patient.patientName}" required>
                </div>

                <div class="col-md-6">
                    <label for="gender" class="form-label">Gender</label>

                    <select id="gender" name="gender" class="form-select" required >
                        <span id="genderError" style="color:red;"></span>
                        <option selected disabled>Choose...</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Others">Others</option>
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
                        <c:forEach var="bg" items="${bloodGroupDtos}">
                            <option value="${bg.bloodGroup}"
                            <c:if test="${patient.bloodGroup == bg.bloodGroup}">selected</c:if>>
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
                        // When specialisation changes, fetch doctors
                     document.getElementById("specialisation").addEventListener("change", function() {
                         let specialisation = this.value;
                         let doctorSelect = document.getElementById("doctor");
                         let slotSelect = document.getElementById("slot");

                         console.log("Selected Specialisation:", specialisation);

                         // reset doctor and slot dropdowns
                         doctorSelect.innerHTML = "<option value=''>-- Select Doctor --</option>";
                         slotSelect.innerHTML = "<option value=''>-- Select Slot --</option>";

                         if (!specialisation) return;

                         // Call controller to get doctors
                         let xhr = new XMLHttpRequest();
                         xhr.open("GET", "http://localhost:8080/Hospital/api/fetchDoctor/" + specialisation, true);
                         xhr.onload = function () {
                             console.log("Doctor API response status:", xhr.status);
                             console.log("Doctor API response text:", xhr.responseText);

                             if (xhr.status === 200) {
                                 let response = xhr.responseText.trim();
                                 if (response && response !== "No Doctors Found" && response !== "No doctors") {
                                     let doctors = response.split(",");
                                     console.log("Parsed Doctors Array:", doctors);
                                     doctors.forEach(function (doc) {
                                         let parts = doc.split("|"); // doctorName|id
                                         console.log("Doctor parts:", parts);
                                         let option = document.createElement("option");
                                         option.value = parts[1];  // doctorId
                                         option.text = parts[0];   // doctorName
                                         doctorSelect.add(option);
                                     });
                                 } else {
                                     console.log("No doctors returned for this specialisation.");
                                 }
                             }
                         };
                         xhr.onerror = function() {
                             console.error("Error fetching doctors!");
                         };
                         xhr.send();
                     });

                     // When doctor changes, fetch slots
                     document.getElementById("doctor").addEventListener("change", function() {
                         let doctorId = this.value;
                         let slotSelect = document.getElementById("slot");

                         console.log("Selected Doctor ID:", doctorId);

                         // reset slots
                         slotSelect.innerHTML = "<option value=''>-- Select Slot --</option>";

                         if (!doctorId) return;

                         let xhr = new XMLHttpRequest();
                         xhr.open("GET", "http://localhost:8080/Hospital/api/fetchTimeSlot?id=" + doctorId, true);
                         xhr.onload = function () {
                             console.log("TimeSlot API response status:", xhr.status);
                             console.log("TimeSlot API response text:", xhr.responseText);

                             if (xhr.status === 200) {
                                 let response = xhr.responseText.trim();
                                 if (response && response !== "Not Assigned") {
                                     let slots = response.split("|");
                                     console.log("Parsed Slots Array:", slots);
                                     slots.forEach(function (s) {
                                         let parts = s.split(","); // timeSlot,id
                                         console.log("Slot parts:", parts);
                                         let option = document.createElement("option");
                                         option.value = parts[1];  // slotId
                                         option.text = parts[0];   // timeSlot
                                         slotSelect.add(option);
                                     });
                                 } else {
                                     console.log("No slots returned for this doctor.");
                                 }
                             }
                         };
                         xhr.onerror = function() {
                             console.error("Error fetching slots!");
                         };
                         xhr.send();
                     });

                    </script>

                    </body>
                    </html>