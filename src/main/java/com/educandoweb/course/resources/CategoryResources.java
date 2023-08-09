package com.educandoweb.course.resources;

import com.educandoweb.course.Services.CategoryService;
import com.educandoweb.course.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// implementação de endpoints
@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @Autowired
    private CategoryService service;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
       List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category Category = service.findById(id);
        return ResponseEntity.ok().body(Category);
    }


}
