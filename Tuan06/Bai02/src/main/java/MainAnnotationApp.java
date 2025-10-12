import configs.AnnotationConfig;
import models.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Employee employee = context.getBean(Employee.class);

        System.out.println("Annotation DI: " + employee);
    }
}