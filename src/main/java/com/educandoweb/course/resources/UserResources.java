package com.educandoweb.course.resources;

import com.educandoweb.course.Services.UserService;
import com.educandoweb.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// implementação de endpoints
@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;
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


}
