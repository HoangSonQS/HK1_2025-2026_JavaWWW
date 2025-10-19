package iuh.fit.se.springdatajpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role",unique = true, nullable = false)
    private String role;
    @Column(name = "name",unique = true, nullable = false)
    private String name;

    public Employee() {
    }

    public Employee(int id, String role, String name) {
        this.id = id;
        this.role = role;
        this.name = name;
    }

    public Employee(String role, String name) {
        this.role = role;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
