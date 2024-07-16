package com.mruruc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "employees")
@Entity
@Table(name = "departments", schema = "public")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_pk_sequence_generator")
    @SequenceGenerator(name = "department_pk_sequence_generator", allocationSize = 1)
    @Column(name = "department_id")
    private Long departmentId;
    @Column(columnDefinition = "VARCHAR", length = 20, name = "department_name", nullable = false)
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
