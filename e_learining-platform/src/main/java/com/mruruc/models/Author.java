package com.mruruc.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email",name = "unique_constraint_email")
        }
)
public class Author extends BaseEntity{
    @Id
    @GeneratedValue
            //(strategy = GenerationType.AUTO
//            , generator = "author_sequence"
//    )
//    @SequenceGenerator(name = "author_sequence",
//                    sequenceName = "author_id_gen_sequence",
//                    allocationSize = 1
//    )
    private Long id;
    @Column(length = 50,updatable = false,nullable = false)
    private String firstName;
    @Column(length = 50,nullable = false)
    private String lastName;
    @Column(length = 100,unique = true,nullable = false)
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dob;
    @ManyToMany(mappedBy = "authors",cascade = CascadeType.PERSIST)
    private List<Course> courses;

    public Author(){}

    public Author(Long id, String firstName, String lastName, String email, LocalDate dob, List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.courses = courses;
    }

    public Author(LocalDateTime createdAt, LocalDateTime lastModifiedAt,
                  String createdBy, String lastModified,
                  Long id, String firstName, String lastName,
                  String email, LocalDate dob) {
        super(createdAt, lastModifiedAt, createdBy, lastModified);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.courses = courses;
    }

    public Author(String firstName, String lastName,
                  String email, LocalDate dob,List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.courses=courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
           ///     ", courses=" + courses +
                ", age=" + getAge() +
                ", createdAt=" + getCreatedAt() +
                ", lastModifiedAt=" + getLastModifiedAt() +
                ", createdBy='" + getCreatedBy() + '\'' +
                ", lastModified='" + getLastModified() + '\'' +
                '}';
    }
}
