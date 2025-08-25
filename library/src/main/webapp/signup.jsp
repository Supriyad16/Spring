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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
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
                <a class="btn btn-dark fw-bold" aria-current="page" href="index.jsp">Home</a>
            </li>

                <li class="nav-item">
                    <a class="btn btn-dark fw-bold" aria-current="page" href="#">SignUp</a>
                </li>


            </ul>
        </div>
    </div>
</nav>
<div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
    <div class="p-5 shadow-lg mb-5 rounded bg-light">
        <h3 class="fw-bold display-4 text-center text-dark mb-3">Register Form</h3>



        <form action="signup" class="bg-light p-4 border rounded" method="post">

            <span style="color:red">${error}</span>
            <span style="color:green">${success}</span>
        <div class="mb-3">
                <label for="nameId" class="form-label">Name</label>
                <input type="text" oninput="validateName()" class="form-control" id="nameId" name="name" required>
                <span id="nameErrorId" class="text-danger"></span>
            </div>

            <div class="mb-3">
            <label for="ageId" class="form-label">Age</label>
            <input type="text" class="form-control" oninput="validateAge()" id="ageId" name="age" required>
            <span class="text-danger" id="ageErrorId"></span>
        </div>

            <div class="mb-3">
                <label for="lib_id" class="form-label">Library Id</label>
                <input type="text" class="form-control" oninput="validateId()" id="lib_id" name="lib_id" required>
                <span class="text-danger" id="lib_idErrorId"></span>
            </div>

            <div class="mb-3">
            <label for="genderId" class="form-label">Gender</label>
            <select class="form-select" aria-label="Default select example" onchange="validateGender()" name="gender" id="genderId" required>
                <option selected>Select Gender</option>
                <option value="m">Male</option>
                <option value="f">Female</option>
                <option value="o">other</option>
            </select>
            <span class="text-danger" id="genderErrorId"></span>
        </div>
            <div class="mb-3">
                <label for="emailId" class="form-label">Email</label>
                <input type="email" oninput="validateEmail()" class="form-control" id="emailId" name="email" required>
                <span id="emailErrorId" class="text-danger"></span>
            </div>
            <div class="mb-3">
                <label for="phoneId" class="form-label">Phone No</label>
                <input type="number" class="form-control" oninput="validatePhone()" id="phoneId" name="phone" required>
                <span class="text-danger" id="phoneErrorId"></span>
            </div>


            <div class="form-floating">
                <textarea class="form-control" name="address" id="addressId" style="height: 100px" required></textarea>
                <label for="addressId">Address</label>
            </div>

            <div class="mb-3">
                <label for="books_taken" class="form-label">Books Taken</label>
                <input type="text" class="form-control" oninput="validateId()" id="books_taken" name="booksTaken" required>
                <span class="text-danger" id="BooksErrorId"></span>
            </div>

            <div class="mb-3 ">
                <label for="passwordId" class="form-label" >Password</label>
                <div class="position-relative">
                    <input type="password" class="form-control" oninput="validatePassword()" name="password" id="passwordId" required>
                    <button type="button" class="position-absolute top-50 end-0 translate-middle-y text-danger  border-0 bg-transparent" onclick="viewPassword()">
                        <i class="bi bi-eye" id="toggleIcon"></i>
                    </button>
                </div>
                <span id="passwordErrorId" class="text-danger"></span>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label" >Confirm Password</label>
                <input type="password" class="form-control" oninput="validateConfirmPassword()" id="confirmPassword" name="confirmPassword" required>
                <span id="cpasswordErrorId" class="text-danger"></span>
            </div>

            <div class="mb-3">
                <button class="btn btn-info text-white fw-bold w-100">Submit</button>

            </div>
        </form>
    </div>
</div>

</body>
</html>