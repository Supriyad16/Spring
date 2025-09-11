<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Profile</title>
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
            </ul>
        </div>
    </div>
</nav>


<div class="container d-flex justify-content-center mt-4 align-items-center min-vh-100">
    <div class="p-5 shadow-lg mb-5 rounded bg-light">
        <h3 class="fw-bold display-4 text-center text-dark mb-3">Update Profile</h3>

        <form action="updateProfile" method="post" class="bg-light p-4 border rounded">

            <span style="color:red">${error}</span>
            <span style="color:green">${success}</span>

            <div class="mb-3">
                <label for="nameId" class="form-label">Name</label>
                <input type="text" class="form-control" id="nameId" name="name" value="${value.name}" required>
            </div>

            <div class="mb-3">
                <label for="emailId" class="form-label">Email</label>
                <input type="email" class="form-control" id="emailId" name="email" value="${value.email}" required >
            </div>

            <div class="mb-3">
                <label for="ageId" class="form-label">Age</label>
                <input type="number" class="form-control" id="ageId" name="age" value="${value.age}" required>
            </div>

            <div class="mb-3">
                <label for="libraryId" class="form-label">Library Id</label>
                <input type="number" class="form-control" id="libraryId" name="libraryId" value="${value.libraryId}" required>
            </div>


            <div class="mb-3">
                <label for="phoneId" class="form-label">Phone No</label>
                <input type="number" class="form-control" id="phoneId" name="phoneNumber" value="${value.phoneNumber}" required>
            </div>

            <div class="form-floating mb-3">
                <textarea class="form-control" name="address" id="addressId" style="height: 100px" required>${value.address}</textarea>
                <label for="addressId">Address</label>
            </div>

            <div class="mb-3">
                <button class="btn btn-info text-white fw-bold w-100">Update</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
