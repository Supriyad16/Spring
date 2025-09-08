<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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

            <form action="admin" method="post">
                <div class="mb-3">
                    <label for="emailId" class="form-label fw-semibold">Email</label>
                    <input type="email" class="form-control" id="emailId" name="email" required>
                </div>

                <div class="mb-3">
                    <label for="otp" class="form-label fw-semibold">OTP</label>
                    <input type="text" class="form-control" id="otp" name="otp" required>
                </div>

                <span class="badge bg-secondary p-2">
        <a class="btn btn-secondary text-white fw-bold" href="admin.jsp">Submit</a>
      </span>
            </form>
        </div>
    </div>

</div>

<script>
    function userEmail() {
    console.log("HELLO");

    let name = document.getElementById("emailId");
    let nameValue = name.value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/Hospital/userEmail/" + nameValue, true);
    xhttp.send();

    xhttp.onload = function () {
    document.getElementById("displayEmail").innerHTML = this.responseText;
    }
    }

</script>

</body>
</html>
