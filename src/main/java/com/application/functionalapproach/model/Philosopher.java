package com.application.functionalapproach.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@EqualsAndHashCode
@With
public class Philosopher {

    //id field with @Id is mandatory
    @Id
    //@GeneratedValue is to specify the column increment strategy
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Integer id;

    private final String name;

    private final int age;

    private final String category;


    public Philosopher(Integer id, String name, int age, String category) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.category = category;
    }
}
