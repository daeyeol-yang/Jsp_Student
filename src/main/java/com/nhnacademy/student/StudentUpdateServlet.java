package com.nhnacademy.student;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name="studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    public void init(ServletConfig config) throws ServletException{
        studentRepository =(StudentRepository) config.getServletContext().getAttribute("studentRepository");
        if (studentRepository == null) {
            throw new ServletException("StudentRepository not found in ServletContext");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/student/register.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("update call()");
        String id = req.getParameter("id");
        String name =req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age = Integer.parseInt(req.getParameter("age"));
        LocalDateTime time = LocalDateTime.now();
        Student student = new Student(id,name,gender,age, time);
        studentRepository.update(student);

        resp.sendRedirect("/student/view?id="+student.getId());

    }
}
