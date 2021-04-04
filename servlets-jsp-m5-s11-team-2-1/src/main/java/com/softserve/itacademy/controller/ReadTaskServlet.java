package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/read-tasks")
public class ReadTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }
                         // client -> to me            me -> to client
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("id"));
        Task task = taskRepository.read(index);
        if(task == null){
           response.sendError(404);
        }else {
        request.setAttribute("task",task);
        request.getRequestDispatcher("/WEB-INF/pages/read-task.jsp").forward(request,response);}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
