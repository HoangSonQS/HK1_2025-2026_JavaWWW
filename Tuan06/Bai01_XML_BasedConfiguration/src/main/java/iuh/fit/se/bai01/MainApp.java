package iuh.fit.se.bai01;

import iuh.fit.se.bai01.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student1", Student.class);
        System.out.println(student1);
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student2);
        Student student3 = context.getBean("student3", Student.class);
        System.out.println(student3);
    }
}
