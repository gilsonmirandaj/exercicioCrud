package com.exercise.controller;

import com.exercise.Repository.CategoryRepository;
import com.exercise.Repository.ProductRepository;
import com.exercise.model.Category;
import com.exercise.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<Category>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Category>> GetByTitulo(@PathVariable String description){
        return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(description));
    }

    @PostMapping
    public ResponseEntity<Category> post (@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(category));
    }

    @PutMapping
    public ResponseEntity<Category> put (@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(category));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }

}
