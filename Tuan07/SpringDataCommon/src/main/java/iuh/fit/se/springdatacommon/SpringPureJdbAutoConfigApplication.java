package iuh.fit.se.springdatacommon;

import iuh.fit.se.springdatacommon.dao.EmployeeDAO;
import iuh.fit.se.springdatacommon.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//@SpringBootApplication(scanBasePackages = {"iuh.fit.se.springdatacommon.dao", "iuh.fit.se.springdatacommon.dao.impl"})
public class SpringPureJdbAutoConfigApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringPureJdbAutoConfigApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner runner(EmployeeDAO employeeDAO) {
//        return args -> {
//            Employee employee = new Employee("Nguyen Van A", "Super Admin");
//            employeeDAO.save(employee);
//
//            List<Employee> employees = employeeDAO.getAll();
//            System.out.println("--- DANH SÁCH TẤT CẢ ---");
//            employees.forEach(System.out::print);
//
//            Employee employee2 = employeeDAO.getById(1);
//            System.out.println("\n--- EMPLOYEE ID 1 ---");
//            System.out.println(employee2);
//
//            Employee employeeDirectMapper = employeeDAO.getByIdDirectMapper(1);
//            System.out.println("\n--- EMPLOYEE ID 1 (Direct Mapper) ---");
//            System.out.println(employeeDirectMapper);
//        };
//    }
}