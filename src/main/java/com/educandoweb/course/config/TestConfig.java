package com.educandoweb.course.config;

import com.educandoweb.course.Repositories.*;
import com.educandoweb.course.entities.*;
import com.educandoweb.course.entities.enums.OrderStatus;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of The Rings", "Adventure Book by Tolkien",29.9," ");
        Product p2 = new Product(null, "Smart TV Samsumg 56 pol", "Brand new",299.9," ");
        Product p3 = new Product(null, "Macbook Pro M1 16gb", "15 pol., brand new",799.9," ");
        Product p4 = new Product(null, "One Hundred Years of Solitude", "Magical Realism Book by Gabriel Garcia Marquez",39.9," ");
        Product p5 = new Product(null, "Things Fall Apart", "Drama Book by Chinua Achebe",69.9," ");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        // adiciona os produtos às suas categorias
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat2);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Maria Brown", "mariab@gmail.com", "99988-8888", "passowrdmaria");
        User u2 = new User(null, "Alex Rosa", "alex@gmail.com", "98778-6688", "passowrdalex");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-22T19:53:07Z"), OrderStatus.DELIVERED, u1);
        Order o2 = new Order(null, Instant.parse("2022-10-07T19:42:10Z"), OrderStatus.CANCELED,u2);
        Order o3 = new Order(null, Instant.parse("2023-07-22T21:21:22Z"),OrderStatus.PAID, u1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
        OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
        OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
        OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null,Instant.parse("2023-07-22T21:23:10Z"), o3);
        o3.setPayment(pay1);

        orderRepository.save(o3);


    }
}
