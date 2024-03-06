package com.mruruc.models;

import com.mruruc.models.resource.Resource;
import jakarta.persistence.*;

@Entity
public class Lecture extends BaseEntity{
    @Id
    @GeneratedValue
    private Long lectureId;
    @Column(nullable = false)
    private String lectureName;
    @ManyToOne
    @JoinColumn(name = "section_id",nullable = false)
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
