package com.mruruc.models.resource;

import com.mruruc.models.Lecture;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("Text")
public class Text extends Resource{
    private String content;

    public Text(){}

    public Text(Long resourceId, Lecture lecture, String content) {
        super(resourceId, lecture);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
