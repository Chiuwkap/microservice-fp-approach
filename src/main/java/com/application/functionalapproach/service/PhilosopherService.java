package com.application.functionalapproach.service;

import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.repository.PhilosopherRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
public class PhilosopherService {

    private final PhilosopherRepository philosopherRepository;

    //Constructor Injection
    private PhilosopherService(PhilosopherRepository philosopherRepository) {
        this.philosopherRepository = philosopherRepository;
    }

    public Iterable<Philosopher> getAllPhilosopher(){
        return philosopherRepository.findAll();
    }

    public Optional<Philosopher> getPhilosopherById(final Long id){
            return philosopherRepository.findById(id);
    }

    public Optional<List<Philosopher>> getPhilosopherByCategory(final String category){
        return philosopherRepository.findByCategory(category);
    }

    // Stream API Operations
    public Optional<Integer> getOldestPhilosopherByAge() {

        List<Philosopher> philosophers = new ArrayList<>();
        Comparator<Philosopher> comparator = Comparator.comparing(Philosopher::getAge);
        Optional<Philosopher> getOldestOne = philosophers.stream().max(comparator);

        return philosopherRepository.findOldestPhilosopherByAge(getOldestOne);
    }


}
