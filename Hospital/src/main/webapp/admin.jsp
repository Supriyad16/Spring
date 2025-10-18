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
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">
    </script>
    <link href="https://fonts.googleapis.com/css2?family=Quintessential&display=swap" rel="stylesheet">


    <style>
        body {
            margin: 0;
            height: 100vh;
            background: url('images/hospital.png') no-repeat center center fixed;
            background-size: cover;
            padding-top: 80px;
            font-family: Arial, sans-serif;
        }

        .navbar {
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 1000;
        }

        .card-container {
            width: 400px;
            height: auto;
            background: rgba(255, 255, 255, 0.45);
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

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand fs-4" href="#">
            <img src="doctor.jpg" alt="" width="40" height="40" class="d-inline-block align-text-top me-2">
            Sushrutha Chikitsalaya
        </a>
    </div>
</nav>

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
                       onchange="UserEmail()" placeholder="Enter email" required>
                <p id="displayEmail"></p>
            </div>


            <!-- Send OTP -->
            <button type="button" class="btn btn-primary btn-custom" onclick="sendOtp()">Send OTP</button>


            <!-- OTP Input -->
            <div class="mb-3 text-start mt-3">
                <label for="otp" class="form-label fw-semibold">OTP</label>
                <input type="text" class="form-control" id="otp" name="otp" placeholder="Enter OTP" required >
            </div>


            <!-- Submit -->
            <button type="submit" class="btn btn-success btn-custom" >Login</button>


            <!-- OTP Countdown -->
            <div id="otpTimer" class="text-danger fw-bold mt-2 mb-3"></div>

            <div class="d-flex justify-content-center align-items-center mb-3">
                <span id="timeCountId" class="text-dark fw-semibold"></span>
                <button type="button" class="btn btn-outline-dark btn-sm ms-1" id="resendId" onclick="resetTimeOtp()" disabled>
                    Resend OTP
                </button>
                <span id="timeoutMessageId" class="text-danger ms-2"></span>
            </div>
        </form>
    </div>
</div>

<script>
    let timer; // global countdown variable

    // ✅ Check if user email exists
    function UserEmail() {
        let email = document.getElementById("emailId").value;
        if (!email) return;

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/userEmail/" + encodeURIComponent(email), true);
        xhttp.send();

        xhttp.onload = function () {
            document.getElementById("displayEmail").innerHTML = this.responseText;
        };
    }

    // ✅ Countdown for resend OTP (2 minutes)
    function timeCount() {
        let timeCountEl = document.getElementById("timeCountId");
        let resend = document.getElementById("resendId");
        let timeoutMessage = document.getElementById("timeoutMessageId");

        let expiryTime = Date.now() + 120000; // 2 minutes

        if (timer) {
            clearInterval(timer);
        }

        timer = setInterval(function () {
            const remainingTime = Math.floor((expiryTime - Date.now()) / 1000);

            if (remainingTime > 0) {
                timeCountEl.textContent = `Resend OTP in ${remainingTime}s`;
                resend.disabled = true;
                timeoutMessage.textContent = "";
            } else {
                timeCountEl.textContent = "";
                timeoutMessage.textContent = "Time Out. You can resend OTP";
                resend.disabled = false;
                clearInterval(timer);
            }
        }, 1000);
    }

    // ✅ Send OTP
    function sendOtp() {
        let email = document.getElementById("emailId").value;
        if (!email) {
            alert("Please enter your email before sending OTP");
            return;
        }

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/sendOtp/" + encodeURIComponent(email), true);
        xhttp.send();

        xhttp.onload = function () {
            alert(this.responseText); // Message from backend
            if (this.responseText.includes("OTP sent successfully")) {
                timeCount(); // start countdown timer
            }
        };
    }

    // ✅ Resend OTP
    function resetTimeOtp() {
        let email = document.getElementById("emailId").value;
        if (!email) {
            alert("Please enter email first");
            return;
        }

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/sendOtp/" + encodeURIComponent(email), true);
        xhttp.send();

        xhttp.onload = function () {
            alert("New OTP sent successfully!");
            timeCount(); // restart countdown
        };
    }
</script>
</body>
</html>