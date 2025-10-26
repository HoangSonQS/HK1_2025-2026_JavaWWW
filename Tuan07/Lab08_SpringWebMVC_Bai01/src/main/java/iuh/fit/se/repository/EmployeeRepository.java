package iuh.fit.se.repository;

import iuh.fit.se.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE " +
            "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "e.phone LIKE CONCAT('%', :keyword, '%') OR " +
            "LOWER(e.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    public List<Employee> searchByAllFields(@Param("keyword") String keyword);
}
