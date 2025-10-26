package iuh.fit.se.configs;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Autowired
    public DataInitializer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (employeeService.getAll().isEmpty()) {
            System.out.println("--- ĐANG KHỞI TẠO DỮ LIỆU MẪU ---");

            Employee e1 = new Employee(null, "Nguyen", "Anh", "anhnguyen@gmail.com",
                    LocalDate.of(2025, 9, 20), "(123)456-7899", true, "123 Vo Van Ngan");

            Employee e2 = new Employee(null, "Le", "Minh", "minhle@gmail.co",
                    LocalDate.of(2025, 10, 6), "(123)345-6789", true, "456 Le Van Viet");

            Employee e3 = new Employee(null, "Trần", "Hà", "hatran@gmail.com",
                    LocalDate.of(2000, 5, 15), "(987)654-3210", false, "789 Dinh Phong Phu");

            Employee e4 = new Employee(null, "Phạm", "Tuấn", "tuanpham@gmail.com",
                    LocalDate.of(1999, 2, 28), "(555)123-4567", true, "101 Man Thien");

            Employee e5 = new Employee(null, "Đặng", "Mai", "maidang@gmail.com",
                    LocalDate.of(2002, 11, 30), "(222)333-4444", false, "202 La Xuan Oai");

            employeeService.save(e1);
            employeeService.save(e2);
            employeeService.save(e3);
            employeeService.save(e4);
            employeeService.save(e5);

            System.out.println("--- KHỞI TẠO DỮ LIỆU HOÀN TẤT ---");
        }
    }
}