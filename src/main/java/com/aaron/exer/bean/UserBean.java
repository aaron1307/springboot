package com.aaron.exer.bean;

import com.aaron.exer.validator.UserName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by AaronC on 3/26/2017.
 */
@Entity
public class UserBean implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", length=30)
    @UserName
    @NotEmpty(message = "name should not be empty")
    private String name;

    @Column(name = "birthday", length=30)
    private LocalDate birthday;

    public UserBean() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
