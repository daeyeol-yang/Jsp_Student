package com.nhnacademy.student;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name="studnetListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository =(StudentRepository) config.getServletContext().getAttribute("studentRepository");
        //ServletConfig에서 ServletContext를 얻어옵니다.
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList=studentRepository.getStdents();
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);

        //dispatch -> 명령을 지시하거나 전달하는 것
    }
}
