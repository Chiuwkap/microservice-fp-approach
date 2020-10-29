package com.application.functionalapproach.repository;

import com.application.functionalapproach.model.Philosopher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface PhilosopherRepository extends CrudRepository<Philosopher, Long> {

    /**
    * Query Methods
    */
    List<Philosopher> findByCategory(String category);

    @Query("SELECT max(age) FROM Philosopher")
    Integer findOldestPhilosopherByAge(Optional<Philosopher> b);

}

