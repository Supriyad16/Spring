<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Hospital Admin Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <style>
        /* Full page background */
        body {
            margin: 0;
            height: 100vh;
            background: url('images/hospital.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px; /* space for fixed navbar */
            font-family: Arial, sans-serif;
        }

        /* Fixed navbar */
        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }

        /* Centered login card */
        .card-container {
            width: 400px;
            height: 400px;
            background: rgba(255, 255, 255, 0.45); /* more transparent */
            backdrop-filter: blur(8px);
            border-radius: 20px;
            padding: 40px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.4);
            display: flex;
            flex-direction: column;
            justify-content: center;
        }

        .btn-custom {
            width: 100%;
            margin-top: 10px;
        }

        #displayEmail {
            color: red;
            font-size: 0.9rem;
            margin-top: 5px;
        }
    </style>
</head>
<body>

<!-- Fixed Navbar -->
<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
    </div>
</nav>

<!-- Centered Login Card -->
<div class="d-flex justify-content-center align-items-center min-vh-100">
    <div class="card-container text-center">

        <h3 class="fw-bold display-6 text-dark mb-4">Admin Login</h3>

        <c:if test="${not empty message}">
            <div class="alert alert-info">${message}</div>
        </c:if>

        <form action="admin" method="post">
            <!-- Email -->
            <div class="mb-3 text-start">
                <label for="emailId" class="form-label fw-semibold">Email</label>
                <input type="email" class="form-control" id="emailId" name="email"
                       onchange="checkUserEmail()" placeholder="Enter email" required>
                <p id="displayEmail"></p>
            </div>

            <!-- Send OTP -->
            <button type="button" class="btn btn-primary btn-custom" onclick="sendOtp()">Send OTP</button>

            <!-- OTP Countdown -->
            <div id="otpTimer" class="text-danger fw-bold mt-2 mb-3"></div>

            <!-- OTP Input -->
            <div class="mb-3 text-start mt-3">
                <label for="otp" class="form-label fw-semibold">OTP</label>
                <input type="text" class="form-control" id="otp" name="otp" placeholder="Enter OTP" required>
            </div>



            <!-- Submit -->
            <button type="submit" class="btn btn-success btn-custom">Login</button>
        </form>

    </div>
</div>

<script>
    // Check if user email exists
    function checkUserEmail() {
        let email = document.getElementById("emailId").value;
        if (!email) return;

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/userEmail/" + encodeURIComponent(email), true);
        xhttp.send();

        xhttp.onload = function () {
            document.getElementById("displayEmail").innerHTML = this.responseText;
        }
    }


function startOtpTimer(duration = 300) {
    clearInterval(otpCountdown);
    let timer = duration;

    otpCountdown = setInterval(() => {
        if (timer < 0) {
            clearInterval(otpCountdown);
            document.getElementById('otpTimer').textContent = "OTP expired. Please resend.";
            return;
        }
        const minutes = Math.floor(timer / 60).toString().padStart(2, '0');
        const seconds = (timer % 60).toString().padStart(2, '0');
        document.getElementById('otpTimer').textContent = `OTP valid for: ${minutes}:${seconds}`;
        timer--;
    }, 1000);
}

// Send OTP function
function sendOtp() {
    let email = document.getElementById("emailId").value;
    if (!email) {
        alert("Please enter email first");
        return;
    }

    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/Hospital/sendOtp/" + encodeURIComponent(email), true);
    xhttp.send();

    xhttp.onload = function () {
        alert(this.responseText);
        startOtpTimer(); // start 5-minute countdown after OTP is sent
    }
}
</script>

</script>

</body>
</html>
