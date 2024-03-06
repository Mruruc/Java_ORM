package com.mruruc.models.resource;

import com.mruruc.models.Lecture;
import jakarta.persistence.*;
import org.hibernate.annotations.Polymorphism;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "resource_type")
// @Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource {
    @Id
    @GeneratedValue
    private Long resourceId;
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public Resource() {}

    public Resource(Long resourceId, Lecture lecture) {
        this.resourceId = resourceId;
        this.lecture = lecture;
    }

}
