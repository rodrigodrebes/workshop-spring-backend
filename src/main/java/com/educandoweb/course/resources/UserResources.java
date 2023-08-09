package com.educandoweb.course.resources;

import com.educandoweb.course.Services.UserService;
import com.educandoweb.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// implementação de endpoints
@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    // recuperar dados
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
       List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }


    // inserir dados

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }



}
