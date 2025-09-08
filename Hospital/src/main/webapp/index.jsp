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
            <h3 class="fw-bold display-6 text-center text-dark mb-3">Admin Click here to Login</h3>

            <form action="admin" method="post">
                 <span class="badge bg-secondary p-2">
        <a class="btn btn-secondary text-white fw-bold" href="admin.jsp">Login</a>
      </span>
            </form>
        </div>
    </div>

</div>


</body>
</html>
