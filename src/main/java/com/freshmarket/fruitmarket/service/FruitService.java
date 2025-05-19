package com.freshmarket.fruitmarket.service;

import com.freshmarket.fruitmarket.model.Fruit;
import com.freshmarket.fruitmarket.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }
}