<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>
    
</head>
<body>
    <%@include file="header.html"%>
    <br>
    <h1>Create new Task</h1>
    <h3>${message}</h3><br>
    <table>
    <form action="/create-task" name="createTask" method ="post">
        <table>
            <tr>
                <td>
                    <label for="title">Title: </label>
                </td>
                <td>
                    <input type="text" id="title" name="title" value="${title}">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="priority">Priority: </label>
                </td>
                <td><select name="priority" id="priority">
                    <% System.err.println(request.getAttribute("priority"));
                        Priority object = (Priority)request.getAttribute("priority");
                        object = object==null ? Priority.LOW : object;
                    for( Priority priority: Priority.values()){

                        if(priority.name().equals(object.name())){
                    %>
                    <option value="<%= priority.name()%>" selected>
                        <%= priority.name().charAt(0)+ priority.name().substring(1).toLowerCase()%>
                    </option>
                    <%}

                    else{

                    %>
                    <option value="<%= priority.name()%>">
                        <%= priority.name().charAt(0)+ priority.name().substring(1).toLowerCase()%>
                    </option>
                    <%   }
                       }        %>
                </select></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Create">
                </td>
                <td>
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
    </table>

</body>
</html>
