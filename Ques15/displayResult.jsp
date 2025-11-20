<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/user-input-display-tag" %>

<!DOCTYPE html>
<html>
<head>
<title>Custom Tag Result</title>
<style>
    .section-box {
        border: 1px solid #ccc;
        padding: 15px;
        margin-bottom: 20px;
        background-color: #f9f9f9;
    }
</style>
</head>
<body>

    <h1>Result Page</h1>

    <%
        String name = request.getParameter("userName");
        String ageStr = request.getParameter("userAge");
        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            // Handle error case if age is not a valid number
        }
    %>

    <div class="section-box">
        <my:displayInput name="<%= name %>" age="<%= age %>" />
    </div>

    </body>
</html>