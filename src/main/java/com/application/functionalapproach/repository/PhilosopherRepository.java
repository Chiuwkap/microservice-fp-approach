package com.application.functionalapproach.repository;

import com.application.functionalapproach.model.Philosopher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PhilosopherRepository extends CrudRepository<Philosopher, Long> {

    /**
    * Query Methods
    */
    List<Philosopher> findByCategory(String category);

}
