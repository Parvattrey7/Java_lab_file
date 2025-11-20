<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Input Form</title>
</head>
<body>

    <h1>Enter Your Details</h1>
    <form action="displayResult.jsp" method="post">
        <label for="userName">Name:</label>
        <input type="text" id="userName" name="userName" required><br><br>

        <label for="userAge">Age:</label>
        <input type="number" id="userAge" name="userAge" required><br><br>

        <input type="submit" value="Display Info">
    </form>

</body>
</html>