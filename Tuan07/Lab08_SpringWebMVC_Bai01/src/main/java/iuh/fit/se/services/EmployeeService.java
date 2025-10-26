package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public void update(Employee employee);
    public void delete(Long id);
    public List<Employee> getAll();
    public Employee getById(Long id);
    public List<Employee> searchByKeyword(String keyword);
}
