<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update Doctor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">

    <h2>Update Doctor</h2>

    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="updateDoctor" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${doc.id}">
        <input type="hidden" name="email" value="${doc.email}">

        <div class="mb-3">
            <label>Name</label>
            <input type="text" name="doctorName" class="form-control" value="${doc.doctorName}" required>
        </div>

        <div class="mb-3">
        <select name="specialisation" class="form-select" required>
            <option value="">-- Select Specialisation --</option>
            <c:forEach var="spec" items="${specialisations}">
                <option value="${spec.specialisation}"
                <c:if test="${doc.specialisation eq spec.specialisation}">selected</c:if>>
                ${spec.specialisation}
                </option>
            </c:forEach>
        </select>
        </div>

        <div class="mb-3">
            <label>Qualification</label>
            <input type="text" name="qualification" class="form-control" value="${doc.qualification}" required>
        </div>

        <div class="mb-3">
            <label>Experience (Years)</label>
            <input type="number" name="experience" class="form-control" value="${doc.experience}" required>
        </div>

        <div class="mb-3">
            <label>Phone Number</label>
            <input type="text" name="phoneNumber" class="form-control" value="${doc.phoneNumber}" required>
        </div>

        <div class="mb-3">
            <label>Age</label>
            <input type="number" name="age" class="form-control" value="${doc.age}" required>
        </div>

        <div class="mb-3">
            <label>Gender</label>
            <select name="gender" class="form-select" required>
                <option value="Male" <c:if test="${doc.gender eq 'Male'}">selected</c:if>>Male</option>
                <option value="Female" <c:if test="${doc.gender eq 'Female'}">selected</c:if>>Female</option>
                <option value="Other" <c:if test="${doc.gender eq 'Other'}">selected</c:if>>Other</option>
            </select>
        </div>

        <div class="mb-3">
            <label for="image" class="form-label">Upload Profile Picture</label>
            <input type="file" class="form-control" id="image" name="image" accept="image/*">
            <small id="profilePictureError" class="text-danger"></small>

            <!-- Show existing image preview -->
            <c:if test="${not empty doc.imagePath}">
                <img src="download?imagePath=${doc.imagePath}"
                     alt="Profile"
                     style="width:100px; height:100px; object-fit:cover; margin-top:10px;">
            </c:if>

        </div>

        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Save</button>
            <a href="DoctorList" class="btn btn-secondary">Back</a>
        </div>

    </form>

</div>
</body>
</html>
