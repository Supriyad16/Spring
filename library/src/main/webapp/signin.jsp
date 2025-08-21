<%@ page isELIgnored="false" %>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Applications</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
<script src="index.js"></script>

<nav class="navbar navbar-expand-lg bg-info-subtle">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="#">Supriya X_workz</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="btn btn-info text-white fw-bold" aria-current="page" href="#">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
    <div class="p-5 shadow-lg mb-5 rounded bg-light">
        <h3 class="fw-bold display-4 text-center text-dark mb-3">Sign In</h3>

        <span style="color:red">${error}</span>

        <form action="signin" class="p-4" method="get">
            <div class="mb-3">
                <label for="nameId" class="form-label fw-semibold">UserName</label>
                <input type="text" class="form-control" id="nameId" name="name">
            </div>

            <div class="mb-3">
                <label for="passwordId" class="form-label fw-semibold">Password</label>
                <div class="position-relative">
                    <input type="password" class="form-control" name="password" id="passwordId" required>
                    <button type="button" class="position-absolute top-50 end-0 translate-middle-y text-secondary border-0 bg-transparent" onclick="viewPassword()">
                        <i class="bi bi-eye" id="toggleIcon"></i>
                    </button>
                </div>
                <span id="passwordErrorId" class="text-danger"></span>
            </div>

            <div class="mb-3">
                <button class="btn btn-info text-white fw-bold w-100">Sign In</button>
            </div>

            <div class="text-center mt-2">
                <a href="ForgotPassword.jsp" class="text-decoration-none">Forgot Password?</a>
            </div>
        </form>
    </div>
</div>


</body>
</html>
