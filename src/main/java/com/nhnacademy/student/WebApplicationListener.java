package com.nhnacademy.student;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener  implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        //ServletConTextEvent  서블릿 컨텍스트의 이벤트를 나타내는 인터페이스입니다. 이 인터페이스는 서블릿 컨텍스트의 초기화 및 종료와 같은 이벤트에 사용

        ServletContext context = sce.getServletContext();
        //getServletContext(): 서블릿 컨텍스트 객체를 반환합니다. 서블릿 컨텍스트는 웹 애플리케이션 전체에 대한 정보를 제공하고 관리하는 객체입니다.

        StudentRepository studentRepository = new MapStudentRepository();
        for (int i = 0; i <=10  ; i++) {
            studentRepository.save(student);
        }

    }
}
