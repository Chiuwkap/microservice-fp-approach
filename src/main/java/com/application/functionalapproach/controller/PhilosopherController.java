package com.application.functionalapproach.controller;

import com.application.functionalapproach.execption.ErrorMessage;
import com.application.functionalapproach.model.Philosopher;
import com.application.functionalapproach.service.PhilosopherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/philosopher")
public class PhilosopherController {

    private final PhilosopherService philosopherService;

    private PhilosopherController(PhilosopherService philosopherService){
        this.philosopherService = philosopherService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Philosopher> addPhilosopher(final @RequestBody Philosopher philosopher){
        return new ResponseEntity<>(philosopherService.addPhilosopher(philosopher), HttpStatus.OK);
    }


    @ApiOperation(value = "Fetches philosophers")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 404, message = "No philosopher found with given ID", response = ErrorMessage.class),
                    @ApiResponse(code = 500, message = "Server error", response = ErrorMessage.class)
            })
    @GetMapping("/id/{id}")
    public ResponseEntity<Philosopher> getPhilosopherById(@PathVariable("id") final Long id){
        return philosopherService
                .getPhilosopherById(id)
                .map(ResponseEntity::ok).orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<Philosopher>> getPhilosopherByCategory(@PathVariable("category") final String category){
         return philosopherService
                 .getPhilosopherByCategory(category)
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
