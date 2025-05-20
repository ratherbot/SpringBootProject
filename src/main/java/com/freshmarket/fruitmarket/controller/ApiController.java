package com.freshmarket.fruitmarket.controller;

import com.freshmarket.fruitmarket.model.Fruit;
import com.freshmarket.fruitmarket.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class ApiController {

    @Autowired
    private FruitService service;

    @GetMapping
    public List<Fruit> all() {
        return service.getAllFruits();
    }

    @PostMapping
    public Fruit create(@Valid @RequestBody Fruit fruit) {
        return service.save(fruit);
    }
}