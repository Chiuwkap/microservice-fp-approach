package com.application.functionalapproach.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@ToString
public class Philosopher {

    //id field with @Id is mandatory
    @Id
    //@GeneratedValue is to specify the column increment strategy
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id;

    //@With immutable 'setters'
    @With private final String name;

    @With private final int age;

    public Philosopher(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
