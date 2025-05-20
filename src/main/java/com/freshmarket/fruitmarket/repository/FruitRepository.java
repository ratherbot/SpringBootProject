package com.freshmarket.fruitmarket.repository;

import com.freshmarket.fruitmarket.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> { }