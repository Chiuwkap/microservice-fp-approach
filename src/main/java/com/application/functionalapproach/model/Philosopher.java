package com.application.functionalapproach.model;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "Identifies a Philosopher")
    private final Long id;

    @ApiModelProperty(value = "Name of the Philosopher")
    private final String name;

    @ApiModelProperty(value = "Age of the Philosopher")
    private final int age;

    @ApiModelProperty(value = "Category of the Philosopher")
    private final String category;

}