package com.nhnacademy.student;

import static javax.servlet.RequestDispatcher.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "errorServlet", urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));

        // todo exception_type
        Object exceptionType = req.getAttribute(ERROR_EXCEPTION_TYPE);
        req.setAttribute("exception_type", exceptionType != null ? exceptionType.toString() : "");

        // todo message
        Object errorMessage = req.getAttribute(ERROR_MESSAGE);
        req.setAttribute("message", errorMessage != null ? errorMessage.toString() : "");

        // todo exception
        Object exception = req.getAttribute(ERROR_EXCEPTION);
        req.setAttribute("exception", exception != null ? exception : "");

        // todo request_uri
        Object requestURI = req.getAttribute(ERROR_REQUEST_URI);
        req.setAttribute("request_uri", requestURI != null ? requestURI.toString() : "");

        // todo /error.jsp forward 처리
        req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
}
