<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Hospital Website</title>

    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="doctor.jpg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                Sushrutha Chikitsalaya
            </a>
        </div>
    </nav>
</head>
<body>

<div style="background: url('hospital.png') no-repeat center center;
            background-size: contain;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-align: center;
            flex-direction: column;">

    <div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
        <div class="p-5 shadow-lg mb-5 rounded"
             style="min-width: 400px; background: rgba(255, 255, 255, 0.3); backdrop-filter: blur(8px);">
            <h3 class="fw-bold display-6 text-center text-dark mb-3">Admin Page</h3>

            <c:if test="${not empty message}">
                <div class="alert alert-info">${message}</div>
            </c:if>

            <form action="admin" method="post">
                <div class="mb-3">
                    <label for="emailId" class="form-label fw-semibold">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="emailId" name="email" required>
                    </div>
                </div>
                    <button type="button" class="btn btn-primary" onclick="sendOtp()">Send OTP</button>



                <p id="displayEmail" style="color:red;"></p>

                <div class="mb-3">
                    <label for="otp" class="form-label fw-semibold">OTP</label>
                    <input type="text" class="form-control" id="otp" name="otp" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
    </div>

</div>

<script>

    function userEmail() {
    console.log("HELLO");
        let email = document.getElementById("emailId");
       let emailValue = email.value;

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/userEmail/" + emailValue, true);
        xhttp.send();

        xhttp.onload = function () {
            document.getElementById("displayEmail").innerHTML = this.responseText;
        }
    }


    function sendOtp() {
        let email = document.getElementById("emailId").value;
        if (!email) {
            alert("Please enter email first");
            return;
        }

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/Hospital/sendOtp/" + email, true);

        xhttp.send();

        xhttp.onload = function () {
            alert(this.responseText);
        }
    }
</script>

</body>
</html>
