<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
    <%System.err.print(request.getParameter("id"));%>
    <h1>Task with ID '<%= request.getParameter("id")%>' not found in To-Do List!</h1>

    <h3><b>url: /edit-task </b></h3>

</body>
</html>
