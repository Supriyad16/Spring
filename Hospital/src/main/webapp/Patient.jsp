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

        <!-- Success/Error Messages -->
        <c:if test="${not empty message}">
            <div class="alert alert-success text-center">${message}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>

        <!-- Patient Registration Form -->
        <form action="Patient" method="post">
            <div class="row g-4">
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
                    <select class="form-select" id="bloodGroup" name="bloodGroup" required>
                        <option value="">-- Choose Blood Group --</option>
                        <option value="a+" ${patient.bloodGroup=='a+'?'selected':''}>A +ve</option>
                        <option value="a-" ${patient.bloodGroup=='a-'?'selected':''}>A -ve</option>
                        <option value="b+" ${patient.bloodGroup=='b+'?'selected':''}>B +ve</option>
                        <option value="b-" ${patient.bloodGroup=='b-'?'selected':''}>B -ve</option>
                        <option value="ab+" ${patient.bloodGroup=='ab+'?'selected':''}>AB +ve</option>
                        <option value="ab-" ${patient.bloodGroup=='ab-'?'selected':''}>AB -ve</option>
                        <option value="o+" ${patient.bloodGroup=='o+'?'selected':''}>O +ve</option>
                        <option value="o-" ${patient.bloodGroup=='o-'?'selected':''}>O -ve</option>
                    </select>
                </div>

                <div class="col-12">
                    <label for="disease" class="form-label">Disease</label>
                    <textarea class="form-control" id="disease" name="disease" required>${patient.disease}</textarea>
                </div>

                <label for="disease" class="form-label">Specialisation</label>
                <select id="specialisation" name="specialisation" required>
                    <option value="">-- Select Specialisation --</option>
                    <c:forEach var="spec" items="${slotSpecialisations}">
                        <option value="${spec.specialisation}">${spec.specialisation}</option>
                    </c:forEach>
                </select>

                <label for="disease" class="form-label">Doctor</label>
                <select id="doctor" name="doctorId" class="form-select" required>
                    <option value="">-- Select Doctor --</option>
                </select>

                <label for="disease" class="form-label">slot</label>
                <select id="slot" name="slotId" class="form-select" required>
                    <option value="">-- Select Slot --</option>
                </select>



                <div class="col-12 text-center mt-4">
                    <button type="submit" class="btn btn-primary px-5">Save</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    document.getElementById("specialisation").addEventListener("change", function() {
        let specialisation = this.value.trim();
        if (!specialisation) return;

        let url = "/Hospital/getDoctorAndSlots/" + encodeURIComponent(specialisation);

        fetch(url)
            .then(res => res.json())
            .then(data => {
                let doctorSelect = document.getElementById("doctor");
                doctorSelect.innerHTML = '<option value="">--Select Doctor--</option>';
                data.doctors.forEach(doc => {
                    let opt = document.createElement("option");
                    opt.value = doc.id;
                    opt.text = doc.doctorName;
                    doctorSelect.add(opt);
                });

                let slotSelect = document.getElementById("slot");
                slotSelect.innerHTML = '<option value="">--Select Slot--</option>';
                data.slots.forEach(slot => {
                    let opt = document.createElement("option");
                    opt.value = slot.id;
                    opt.text = slot.fromTime + " - " + slot.toTime;
                    slotSelect.add(opt);
                });
            })
            .catch(err => console.error("Error fetching doctors and slots:", err));
    });
</script>



</body>
</html>
