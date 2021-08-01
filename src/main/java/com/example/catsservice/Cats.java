package com.example.catsservice;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Cats {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    public Cats(String name) {
        Assert.isTrue(Character.isUpperCase(name.charAt(0)), ()->"The firs character of name must be upper case");
        this.name=name;
    }

    public Cats(String name, LocalDate dateOfBirth) {
        this(name);
        this.dateOfBirth = dateOfBirth;
    }

    Cats() {
    }

    public String getName() {
        return name;
    }

    public Integer getAgeInMonths() {
        return Period.between(dateOfBirth,LocalDate.now()).getMonths();
    }
}
