package com.application.functionalapproach.controller;

import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.service.PhilosopherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/id/{id}")
    public Optional<Philosopher> getPhilosopherById(@PathVariable("id") final Long id){
        return philosopherService.getPhilosopherById(id);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Philosopher>> getPhilosopherByCategory(@PathVariable("category") final String category){
         return philosopherService.getPhilosopherByCategory(category)
                 .map(ResponseEntity::ok).orElseGet(() ->
                         new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/oldest")
    public ResponseEntity<Integer> getOldestPhilosopher(){
        return philosopherService
                .getOldestPhilosopherByAge()
                .map(ResponseEntity::ok).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
