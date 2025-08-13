<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bottle Form</title>
</head>
<body>
<h2>Bottle Details</h2>
<form action="bottle" method="post">
    <label for="brand">Brand:</label>
    <input type="text" id="brand" name="brand" required><br><br>

    <label for="material">Material:</label>
    <input type="text" id="material" name="material" required><br><br>

    <label for="color">Color:</label>
    <input type="text" id="color" name="color" required><br><br>

    <label for="capacity">Capacity (in liters):</label>
    <input type="number" id="capacity" name="capacity" step="0.01" required><br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
