package com.application.functionalapproach.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor(force = true)
@EqualsAndHashCode
@AllArgsConstructor
public class Philosopher {

    //id field with @Id is mandatory
    @Id
    //@GeneratedValue is to specify the column increment strategy
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id;

    private final String name;

    private final int age;

    private final String category;

}