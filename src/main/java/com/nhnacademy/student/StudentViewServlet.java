package com.nhnacademy.student;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name="studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository =(StudentRepository) config.getServletContext().getAttribute("studentRepository");
        if (studentRepository == null) {
            throw new ServletException("StudentRepository not found in ServletContext");
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id= req.getParameter("id");
        if(Objects.isNull(id)){
            throw new RuntimeException("parameter [id] : null ");
        }
        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/student/view.jsp").forward(req,resp);
    }


}
