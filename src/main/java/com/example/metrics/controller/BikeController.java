package com.example.metrics.controller;

import com.example.metrics.models.Bike;
import com.example.metrics.service.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BikeController {
    @Autowired
    private IBikeService bikeService;

    @GetMapping(value="/bike", produces="application/json")
    public @ResponseBody ResponseEntity<List<Bike>> findBikes() {
        return new ResponseEntity<>(bikeService.findAll(), null, HttpStatus.OK);
    }

    @PostMapping(value="/bike", consumes = "application/json",produces="application/json")
    public @ResponseBody ResponseEntity<Bike> createBike(@RequestBody Bike b) {
        return new ResponseEntity<>(bikeService.createBike(b.getTitle()), null, HttpStatus.CREATED);
    }
}
