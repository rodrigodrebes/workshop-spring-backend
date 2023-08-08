package com.educandoweb.course.resources;

import com.educandoweb.course.Services.OrderService;
import com.educandoweb.course.Services.UserService;
import com.educandoweb.course.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// implementação de endpoints
@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
       List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }


}
