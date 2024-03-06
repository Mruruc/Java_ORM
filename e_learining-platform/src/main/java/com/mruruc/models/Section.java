package com.mruruc.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Section extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sectionId;
    private String sectionName;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
