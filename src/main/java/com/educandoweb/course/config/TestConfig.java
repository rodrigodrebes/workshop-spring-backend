package com.educandoweb.course.config;

import com.educandoweb.course.Repositories.UserRepository;
import com.educandoweb.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "mariab@gmail.com", "99988-8888", "passowrdmaria");
        User u2 = new User(null, "Alex Rosa", "alex@gmail.com", "98778-6688", "passowrdalex");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
