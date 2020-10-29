package com.application.functionalapproach.controller;

import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.service.PhilosopherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/philosopher")
public class PhilosopherController {

    private final PhilosopherService philosopherService;

    private PhilosopherController(PhilosopherService philosopherService){
        this.philosopherService = philosopherService;
    }

    @GetMapping("/all")
    public Iterable<Philosopher> getAllPhilosopher(){
        return philosopherService.getAllPhilosopher();
    }

    @GetMapping("/id/{id}")
    public Optional<Philosopher> getPhilosopherById(@PathVariable("id") final Long id){
        return philosopherService.getPhilosopherById(id);
    }

    @GetMapping("/category/{category}")
    public List<Philosopher> getPhilosopherByCategory(@PathVariable("category") final String category){
         return philosopherService.getPhilosopherByCategory(category);

    }

    @GetMapping("/oldest")
    public Integer getOldestPhilosopher(){
        return philosopherService.getOldestPhilosopherByAge();
    }
}
