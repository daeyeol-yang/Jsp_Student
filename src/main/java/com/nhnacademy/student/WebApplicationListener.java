package com.nhnacademy.student;

import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        Random random = new Random();
        //ServletConTextEvent  서블릿 컨텍스트의 이벤트를 나타내는 인터페이스입니다. 이 인터페이스는 서블릿 컨텍스트의 초기화 및 종료와 같은 이벤트에 사용

        ServletContext context = sce.getServletContext();
        //getServletContext(): 서블릿 컨텍스트 객체를 반환합니다. 서블릿 컨텍스트는 웹 애플리케이션 전체에 대한 정보를 제공하고 관리하는 객체입니다.

        StudentRepository studentRepository = new MapStudentRepository();
        for (int i = 1; i <=10  ; i++) {
            String id= String.valueOf(i);
            String name= "Stu"+id;
            Gender gender =(random.nextBoolean())? Gender.M:Gender.F;

            int age = random.nextInt(10)+20;
            Student student = new Student(id,name,gender,age);
            studentRepository.save(student);
        }
        context.setAttribute("studentRepository", studentRepository);
        //객체가 ServletContext에 저장되어 다른 서블릿, 필터 또는 리스너에서 이를 공유하고 사용할 수 있습니다.
        //이후에 다른 부분에서 ServletContext를 통해 속성에 접근하여 studentRepository 객체를 가져올 수 있습니다.
        // 이렇게 함으로써 서블릿 컨텍스트 전역에서 studentRepository 객체를 공유하고 활용할 수 있게 됩니다.

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
