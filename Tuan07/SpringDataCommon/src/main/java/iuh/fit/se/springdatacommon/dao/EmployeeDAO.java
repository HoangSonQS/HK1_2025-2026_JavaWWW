package iuh.fit.se.springdatacommon.dao;

import iuh.fit.se.springdatacommon.entity.Employee;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    Employee getById(int id);
    List<Employee> getAll();
    Employee getByIdDirectMapper(int id);
}
