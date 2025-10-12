import models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXmlApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Employee setterEmployee = context.getBean("employeeSetter", Employee.class);
        System.out.println("Setter DI: " + setterEmployee);

        Employee constructorEmployee = context.getBean("employeeConstructor", Employee.class);
        System.out.println("Constructor DI: " + constructorEmployee);
    }
}