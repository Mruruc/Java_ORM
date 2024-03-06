package com.mruruc.models.resource;

import com.mruruc.models.Lecture;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Entity
//@DiscriminatorValue("Video")
// @PrimaryKeyJoinColumn(name = "video_id") //to give the custom name Vide Entity foreign key.
@Polymorphism(type = PolymorphismType.EXPLICIT)
/**
 * When we query to Base Entity it will select all the sub entity,
 * if we do not want to query subclass when we query to base entity we should use it.*/
public class Video extends Resource{
    private Integer length;

    public Video(){}

    public Video(Long resourceId, Lecture lecture, Integer length) {
        super(resourceId,lecture);
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


}
