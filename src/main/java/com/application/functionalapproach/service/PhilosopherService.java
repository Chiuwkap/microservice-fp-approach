package com.application.functionalapproach.service;

import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.repository.PhilosopherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Philosopher> getPhilosopherByCategory(final String category){
        return philosopherRepository.findByCategory(category);
    }


}
