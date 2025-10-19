package iuh.fit.se.springdatajpa;

import iuh.fit.se.springdatajpa.dao.EmployeeDAO;
import iuh.fit.se.springdatajpa.dao.impl.EmployeeDAOImpl;
import iuh.fit.se.springdatajpa.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
        Employee employee1 = new Employee();
        employee1.setRole("Manager");
        employee1.setName("Hoang Son");
        employeeDAO.save(employee1);

        Employee employee2 = new Employee();
        employee2.setRole("Student");
        employee2.setName("Khan");
        employeeDAO.save(employee2);

        List<Employee> employees = employeeDAO.getAll();
        System.out.println("--- DANH SÁCH TẤT CẢ ---");
        employees.forEach(System.out::println);
    }
}
