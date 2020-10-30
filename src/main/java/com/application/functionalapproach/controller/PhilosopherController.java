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

    @ApiOperation(value = "Add a philosopher")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "A Philosopher is added", response = ErrorMessage.class),
            @ApiResponse(code = 400, message = "Invalid input", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorMessage.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Philosopher> addPhilosopher(final @RequestBody Philosopher philosopher){
        return new ResponseEntity<>(philosopherService.addPhilosopher(philosopher), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Fetches philosophers by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No philosopher found with given ID", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorMessage.class)})
    @GetMapping("/id/{id}")
    public ResponseEntity<Philosopher> getPhilosopherById(@PathVariable("id") final Long id){
        return philosopherService
                .getPhilosopherById(id)
                .map(ResponseEntity::ok).orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation(value = "Fetches philosophers by category")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No philosopher found with given category", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorMessage.class)})
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Philosopher>> getPhilosopherByCategory(@PathVariable("category") final String category){
         return philosopherService
                 .getPhilosopherByCategory(category)
                 .map(ResponseEntity::ok).orElseGet(() ->
                         new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @ApiOperation(value = "Fetches the oldest philosopher")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "No philosopher found", response = ErrorMessage.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorMessage.class)})
    @GetMapping("/oldest")
    public ResponseEntity<Integer> getOldestPhilosopher(){
        return philosopherService
                .getOldestPhilosopherByAge()
                .map(ResponseEntity::ok).orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
