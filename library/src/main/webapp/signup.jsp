<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>
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
                    <a class="btn btn-dark fw-bold" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-dark fw-bold" href="signin.jsp">Sign In</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
    <div class="p-5 shadow-lg mb-5 rounded bg-light w-100" style="max-width: 600px;">
        <h3 class="fw-bold display-6 text-center text-dark mb-3">Register Form</h3>


        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul class="mb-0">
                    <c:forEach var="err" items="${errors}">
                        <li>${err.defaultMessage}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="alert alert-success text-center">${success}</div>
        </c:if>


        <form action="signup" method="post" class="bg-light p-3 border rounded">

            <div class="mb-3">
                <label for="nameId" class="form-label">Name</label>
                <input type="text" class="form-control" id="nameId" name="name" required>
            </div>

            <div class="mb-3">
                <label for="ageId" class="form-label">Age</label>
                <input type="number" class="form-control" id="ageId" name="age" required>
            </div>

            <div class="mb-3">
                <label for="lib_id" class="form-label">Library Id</label>
                <input type="text" class="form-control" id="lib_id" name="libraryId" required>
            </div>

            <div class="mb-3">
                <label for="genderId" class="form-label">Gender</label>
                <select class="form-select" name="gender" id="genderId" required>
                    <option value="" selected disabled>Select Gender</option>
                    <option value="m">Male</option>
                    <option value="f">Female</option>
                    <option value="o">Other</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="emailId" class="form-label">Email</label>
                <input type="email" class="form-control" id="emailId" name="email" required oninput="userEmail()">
                <span id="displayEmail" class="text-danger"></span>
            </div>


            <div class="mb-3">
                <label for="phoneId" class="form-label">Phone No</label>
                <input type="number" class="form-control" id="phoneId" name="phone" required>
            </div>

            <div class="form-floating mb-3">
                <textarea class="form-control" name="address" id="addressId" style="height: 100px" required></textarea>
                <label for="addressId">Address</label>
            </div>

            <div class="mb-3">
                <label for="books_taken" class="form-label">Books Taken</label>
                <input type="text" class="form-control" id="books_taken" name="noOfBooksTaken" required>
            </div>

            <div class="mb-3">
                <label for="passwordId" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="passwordId" required>
            </div>

            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>

            <button class="btn btn-info text-white fw-bold w-100">Submit</button>
        </form>
    </div>
</div>

<script>
function userEmail() {
console.log("HELLO");

let name = document.getElementById("emailId");
let nameValue = name.value;

const xhttp = new XMLHttpRequest();
xhttp.open("GET", "http://localhost:8080/library/userEmail/" + nameValue, true);
xhttp.send();

xhttp.onload = function () {
document.getElementById("displayEmail").innerHTML = this.responseText;
}
}

</script>

</body>
</html>
