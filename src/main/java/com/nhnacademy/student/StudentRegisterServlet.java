package com.nhnacademy.student;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "stdentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;

    public void init(ServletConfig config) throws ServletException{
        studentRepository =(StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student/register.jsp").forward(req, resp);
    }

    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        int age= Integer.parseInt(req.getParameter("age"));
        LocalDateTime time = LocalDateTime.now();

        Student student = new Student(id, name, gender, age, time);
        studentRepository.save(student);
        //resp.sendRedirect("/student/view?id=" + student.getId());
        resp.sendRedirect("/student/list" );
    }

}
