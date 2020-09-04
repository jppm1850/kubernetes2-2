package com.application.controller;

import com.application.entity.FruitEntity;
import com.application.entity.FruitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class FruitController {

    private final FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "name") String name) {
        FruitEntity fruit = new FruitEntity(name);
        this.fruitRepository.save(fruit);
        return "created";
    }

    @GetMapping("/list")
    public List<FruitEntity> list() {
        Iterable<FruitEntity> fruits = this.fruitRepository.findAll();
        return StreamSupport.stream(fruits.spliterator(), true).collect(Collectors.toList());
    }
}
