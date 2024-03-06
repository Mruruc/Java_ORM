package com.mruruc.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Course extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 500,nullable = false)
    private String description;
    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;

    public Course(){}

    public Course(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authors=" + authors +
                ", sections=" + sections +
                '}';
    }
}
