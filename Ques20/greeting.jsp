<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Personalized Greeting</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #e6f7ff; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .container { background: white; padding: 30px; border-radius: 12px; box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15); max-width: 400px; width: 90%; }
        h1 { color: #004d99; text-align: center; margin-bottom: 25px; border-bottom: 2px solid #e0e0e0; padding-bottom: 10px; }
        label { display: block; margin-bottom: 6px; font-weight: 600; color: #333; }
        input[type="text"], input[type="number"] { width: 100%; padding: 12px; margin-bottom: 25px; border: 1px solid #b3e0ff; border-radius: 6px; box-sizing: border-box; transition: border-color 0.3s; }
        input[type="text"]:focus, input[type="number"]:focus { border-color: #007bff; outline: none; box-shadow: 0 0 5px rgba(0, 123, 255, 0.2); }
        input[type="submit"] { background-color: #007bff; color: white; padding: 12px 20px; border: none; border-radius: 6px; cursor: pointer; font-size: 16px; width: 100%; transition: background-color 0.3s, transform 0.1s; }
        input[type="submit"]:hover { background-color: #0056b3; }
        input[type="submit"]:active { transform: scale(0.99); }
        .greeting { padding: 20px; background-color: #d4edda; color: #0f5132; border: 1px solid #c3e6cb; border-radius: 8px; font-size: 1.15em; text-align: center; margin-top: 15px; }
        .error { color: #dc3545; text-align: center; margin-top: 15px; font-weight: 500; }
        a { display: block; text-align: center; color: #007bff; margin-top: 20px; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="container">
        <%
            String name = request.getParameter("name");
            String ageParam = request.getParameter("age");
            boolean isValid = true;
            String errorMessage = "";

            if (name != null && !name.trim().isEmpty() && ageParam != null && !ageParam.trim().isEmpty()) {
                int age = 0;
                try {
                    age = Integer.parseInt(ageParam.trim());
        %>
            <h1>Greeting Result</h1>
            <div class="greeting">
                <p>Hello, **<%= name %>**!</p>
                <p>Your age is recorded as **<%= age %>** years.</p>
                
                <% 
                    if (age >= 65) { 
                %>
                    <p>Wishing you a wonderful retirement!</p>
                <% 
                    } else if (age >= 18) { 
                %>
                    <p>You're in your prime—go make something amazing happen!</p>
                <% 
                    } else { 
                %>
                    <p>Enjoy being young!</p>
                <% 
                    } 
                %>
            </div>
            <a href="greeting.jsp">&larr; Go Back</a>
        <%
                } catch (NumberFormatException e) {
                    isValid = false;
                    errorMessage = "Error: Please enter a valid number for age.";
                }
            } else if (name != null || ageParam != null) {
                isValid = false;
                errorMessage = "Error: Both Name and Age fields are required.";
            }

            if (name == null || !isValid) {
        %>
            <h1>Dynamic Greeting Input</h1>
            
            <% if (!isValid && !errorMessage.isEmpty()) { %>
                <p class="error"><%= errorMessage %></p>
            <% } %>

            <form action="greeting.jsp" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${param.name != null ? param.name : ''}" required>

                <label for="age">Age:</label>
                <input type="number" id="age" name="age" min="1" max="150" value="${param.age != null ? param.age : ''}" required>

                <input type="submit" value="Generate Greeting">
            </form>
        <%
            }
        %>
    </div>
</body>
</html>