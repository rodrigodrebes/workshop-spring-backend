package com.educandoweb.course.Repositories;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
