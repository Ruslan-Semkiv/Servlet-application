<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing Task</title>
    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
    <%@include file="header.html"%>
    <br>
    <form action="/edit-task" method="post">

       <%
            Task task = (Task)request.getAttribute("task");
       %>

        <table>
            <tr>
                <td>
                    <label for="id">No.: </label>
                </td>
                <td>
                    <input type="text" id="id" name="id" value="<%=task.getId()%>" disabled>
                </td>
            </tr>
        <tr>
            <td>
                <label for="title">Title: </label>
            </td>
            <td>
                <input type="text" id="title" name="title" value="<%=task.getTitle()%>">
            </td>
        </tr>
            <tr>
                <td>
                    <label for="priority">Priority: </label>
                </td>
                <td><select id="priority" name="priority" value="<%=task.getPriority()%>">
                    <option>Low</option>
                    <option>Medium</option>
                    <option>High</option>
                </select></td>
            </tr>
        <tr>
            <td>
            <input type="submit" value="Update">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
        </table>
    </form>

</body>
</html>
