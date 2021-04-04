<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<table>
    <%@include file="header.html"%> <br>
        <%Task task = (Task) request.getAttribute("task");%>

        <h1>Read existing task</h1>
   <table>
       <p>No: <b><%= task.getId()%></b></p>
       <p>Title: <b><%= task.getTitle()%></b></p>
       <p>Priority: <b><%=task.getPriority()%></b></p>
   </table>
</body>
</html>
