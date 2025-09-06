<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Library App - Sign In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>

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
                    <a class="btn btn-info text-white fw-bold" href="index.jsp">Home</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
    <div class="p-5 shadow-lg mb-5 rounded bg-light" style="min-width: 400px;">
        <h3 class="fw-bold display-6 text-center text-dark mb-3">Sign In</h3>

        <!-- ✅ Show error messages -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>

        <!-- ✅ Show success messages -->
        <c:if test="${not empty success}">
            <div class="alert alert-success text-center">${success}</div>
        </c:if>

        <c:if test="${not empty lockTime}">
            <div class="alert alert-warning text-center">
                Your account is locked. Please wait <span id="countdown"></span> to try again.
            </div>

            <script>
                // lockTime passed from backend in milliseconds
                let unlockAt = ${lockTime} + (5 * 60 * 1000);
                function updateCountdown() {
                    let now = new Date().getTime();
                    let remaining = unlockAt - now;

                    if (remaining <= 0) {
                        document.getElementById("countdown").innerText = "now";
                        return;
                    }

                    let minutes = Math.floor((remaining % (1000 * 60 * 60)) / (1000 * 60));
                    let seconds = Math.floor((remaining % (1000 * 60)) / 1000);

                    document.getElementById("countdown").innerText =
                        minutes + "m " + seconds + "s";

                    setTimeout(updateCountdown, 1000);
                }
                updateCountdown();
            </script>
        </c:if>


        <form action="signin" method="post">
            <div class="mb-3">
                <label for="emailId" class="form-label fw-semibold">Email</label>
                <input type="email" class="form-control" id="emailId" name="email" required>
            </div>

            <div class="mb-3">
                <label for="passwordId" class="form-label fw-semibold">Password</label>
                <input type="password" class="form-control" id="passwordId" name="password" required>
            </div>

            <div class="mb-3">
                <button type="submit" class="btn btn-info text-white fw-bold w-100">Sign In</button>
            </div>

            <div class="text-center mt-2">
                <a href="forgotPassword.jsp" class="text-decoration-none">Forgot Password?</a>
            </div>

            <div class="text-center mt-2">
                <span>Don't have an account? </span>
                <a href="signup.jsp" class="text-decoration-none fw-semibold">Sign Up</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
