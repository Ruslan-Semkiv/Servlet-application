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
import java.io.PrintWriter;

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    private TaskRepository taskRepository;

    @Override
    public void init() {
        taskRepository = TaskRepository.getTaskRepository();
    }

      //в нього прокмдується інфа про запит на сервер \ обєкт в якому міститься інформація про відповідь з сервера що прийде на сторону клієнтп
    protected void doGet(HttpServletRequest request,    HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/pages/create-task.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String titleSt = request.getParameter("title");
        Priority priority = Priority.valueOf(request.getParameter("priority").toUpperCase());
        Task task = new Task(titleSt, priority);
        boolean exists = taskRepository.create(task);

        if(!exists){
                request.setAttribute("message","Task with a given name already exists!");
                request.setAttribute("title",titleSt);
                request.setAttribute("priority",priority);
                request.getRequestDispatcher("/WEB-INF/pages/create-task.jsp").forward(request,response);
        }else{
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect("/tasks-list");
        }
    }
}
