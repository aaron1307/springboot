package com.aaron.exer.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by AaronC on 3/27/2017.
 */
public class FeedbackBean {

    @NotEmpty
    @Length(min=2)
    private String name;
    private String text;

    public FeedbackBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
