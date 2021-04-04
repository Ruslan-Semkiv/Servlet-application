package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init()  {
        taskRepository = TaskRepository.getTaskRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean correctTask = taskRepository.delete(Integer.parseInt(request.getParameter("id")));
        if(correctTask){
            response.sendRedirect("/tasks-list");
        }else{
            request.setAttribute("id",Integer.parseInt(request.getParameter("id")));
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
