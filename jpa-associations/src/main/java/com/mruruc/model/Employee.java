package com.mruruc.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"accessCard","emailGroups"})
@Entity
@Table(name = "employees", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique_constraint", columnNames = {"email"})
        }
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name = "employee_id_generator", allocationSize = 1)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(columnDefinition = "VARCHAR", length = 50, name = "first_name", nullable = false, updatable = false)
    private String firstName;
    @Column(columnDefinition = "VARCHAR", length = 50, name = "last_name", nullable = false, updatable = false)
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR", length = 15, name = "gender", nullable = false)
    private Gender gender;
    @Column(columnDefinition = "VARCHAR", length = 75, name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "salary", nullable = false)
    private Double salary;
    @Column(columnDefinition = "DATE", name = "hire_date", nullable = false)
    private LocalDate hireDate;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "access_card_id", unique = true)
    private AccessCard accessCard;
    @ManyToMany(mappedBy = "groupMembers")
    private List<EmailGroup> emailGroups;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(Long employeeId, String firstName, String lastName, Gender gender, String email,
                    Double salary, LocalDate hireDate, AccessCard accessCard) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
        this.accessCard = accessCard;
    }

    public Employee(String firstName, String lastName, Gender gender, String email, Double salary,
                    LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}

