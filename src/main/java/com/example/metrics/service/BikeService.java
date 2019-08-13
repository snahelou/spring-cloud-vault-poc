package com.example.metrics.service;

import com.example.metrics.models.Bike;
import com.example.metrics.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService  implements IBikeService {

        @Autowired
        private BikeRepository repository;

        public List<Bike> findAll() {
            return (List<Bike>) repository.findAll();
        }

        public Bike createBike(String title){
                Bike b = new Bike();
                b.setTitle(title);
                return repository.save(b);
        }

}

