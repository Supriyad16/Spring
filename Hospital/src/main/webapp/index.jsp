<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <title>Hospital Website</title>

    <style>
        body {
            margin: 0;
            height: 100vh;
            background: url('images/hospital.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px;
        }

        .card-container {
            min-width: 400px;
            background: rgba(255, 255, 255, 0.6);
            backdrop-filter: blur(2px);
            border-radius: 15px;
            padding: 50px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
<nav class="navbar navbar-dark bg-dark py-3 fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
    </div>
</nav>

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card-container text-center">
        <h3 class="fw-bold display-6 text-dark mb-3">Admin Click here to Login</h3>

        <a class="btn btn-primary text-white fw-bold" href="admin.jsp">Login</a>

        <a class="btn btn-primary text-white fw-bold" href="patientList">Patient List</a>


        <!--        <a class="btn btn-primary text-white fw-bold" href="patient">Patient</a>-->

    </div>
</div>

</body>
</html>
