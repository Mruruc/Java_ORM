package com.mruruc.models.resource;

import com.mruruc.models.Lecture;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("File")
public class File extends Resource{
    private String fileType;

    public File() {}

    public File(Long resourceId, Lecture lecture, String fileType) {
        super(resourceId, lecture);
        this.fileType = fileType;
    }
}
