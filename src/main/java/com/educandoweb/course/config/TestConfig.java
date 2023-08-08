package com.educandoweb.course.config;

import com.educandoweb.course.Repositories.OrderRepository;
import com.educandoweb.course.Repositories.UserRepository;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariab@gmail.com", "99988-8888", "passowrdmaria");
        User u2 = new User(null, "Alex Rosa", "alex@gmail.com", "98778-6688", "passowrdalex");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-22T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2022-10-07T19:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-12-22T21:21:22Z"), u1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
