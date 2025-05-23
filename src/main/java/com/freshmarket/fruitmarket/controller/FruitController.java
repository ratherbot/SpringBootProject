package com.freshmarket.fruitmarket.controller;

import com.freshmarket.fruitmarket.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FruitController {

    @Autowired
    private FruitService service;

    @GetMapping({"/", "/fruits"})
    public String list(Model model) {
        model.addAttribute("fruits", service.getAllFruits());
        return "fruits";
    }
}