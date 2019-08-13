package com.example.metrics.service;

import com.example.metrics.models.Bike;

import java.util.List;

public interface IBikeService {
    List<Bike> findAll();
    Bike createBike(String title);
}
