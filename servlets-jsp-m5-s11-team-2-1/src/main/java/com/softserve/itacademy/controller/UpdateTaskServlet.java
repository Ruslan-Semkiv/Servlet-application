package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class UpdateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;
    private Task tasker;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tasker = taskRepository.read(Integer.parseInt(request.getParameter("id")));
        if(tasker == null){
            request.setAttribute("id",request.getParameter("id"));
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        }else{
      request.setAttribute("task",tasker);
        request.getRequestDispatcher("/WEB-INF/pages/edit-task.jsp").forward(request,response);}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        tasker.setTitle(request.getParameter("title"));
       tasker.setPriority(Priority.valueOf(request.getParameter("priority").toUpperCase()));
        taskRepository.update(tasker);
        response.sendRedirect("/tasks-list");
    }
}
