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
        <form class="d-flex">
            <a href="admin.jsp" class="btn btn-outline-light btn-lg">Logout</a>
        </form>
    </div>
</nav>


<div class="container">
    <h2 class="text-center mb-4">Doctor Registration</h2>

    <form class="row g-4" action="doctor" method="post">

        <div class="col-md-6">
            <label for="doctorName" class="form-label">Doctor Name</label>
            <input type="text" class="form-control" id="doctorName" name="doctorName">
        </div>

        <div class="col-md-6">
            <label for="specialisation" class="form-label">Specialisation</label>
            <input type="text" class="form-control" id="specialisation" name="specialisation">
        </div>

        <div class="col-md-6">
            <label for="qualification" class="form-label">Qualification</label>
            <input type="text" class="form-control" id="qualification" name="qualification">
        </div>

        <div class="col-md-6">
            <label for="experience" class="form-label">Experience</label>
            <input type="text" class="form-control" id="experience" name="experience" placeholder="in years">
        </div>

        <div class="col-md-6">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>

        <div class="col-md-6">
            <label for="phoneNumber" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
        </div>

        <div class="col-md-6">
            <label for="gender" class="form-label">Gender</label>
            <select id="gender" name="gender" class="form-select">
                <option selected disabled>Choose...</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Others">Others</option>
            </select>
        </div>

        <div class="col-md-6">
            <label for="age" class="form-label">Age</label>
            <input type="number" class="form-control" id="age" name="age">
        </div>

        <div class="mb-3">
            <label class="form-label">Available Days</label><br>
            <div class="form-check form-check-inline">
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


        <div class="col-md-12">
            <label class="form-label">Available Timings</label>
            <div class="d-flex flex-wrap">
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="8am-12pm" id="time1">
                    <label class="form-check-label" for="time1">8am - 12pm</label>
                </div>
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="12pm-4pm" id="time2">
                    <label class="form-check-label" for="time2">12pm - 4pm</label>
                </div>
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="4pm-8pm" id="time3">
                    <label class="form-check-label" for="time3">4pm - 8pm</label>
                </div>
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="8pm-12am" id="time4">
                    <label class="form-check-label" for="time4">8pm - 12am</label>
                </div>
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="12am-4am" id="time5">
                    <label class="form-check-label" for="time5">12am - 4am</label>
                </div>
                <div class="form-check form-switch me-3">
                    <input class="form-check-input" type="checkbox" name="availableTime" value="4am-8am" id="time6">
                    <label class="form-check-label" for="time6">4am - 8am</label>
                </div>
            </div>
        </div>

        <div class="col-12 text-center mt-4">
            <button type="submit" class="btn btn-primary px-5">Save</button>
        </div>
    </form>


</div>

</body>
</html>
