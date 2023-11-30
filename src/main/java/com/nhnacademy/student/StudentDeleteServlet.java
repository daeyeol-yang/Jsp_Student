package com.nhnacademy.student;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name="studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        studentRepository=(StudentRepository) config.getServletContext().getAttribute("studentRepository");
        if (studentRepository == null) {
            throw new ServletException("StudentRepository not found in ServletContext");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentRepository.deleteById(id);
        if (id == null || id.isEmpty()) {
            throw new RuntimeException("학생 ID가 제공되지 않았습니다.");
        }

        resp.sendRedirect("/student/list" );
    }


}
