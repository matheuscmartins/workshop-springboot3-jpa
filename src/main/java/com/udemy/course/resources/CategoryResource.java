package com.udemy.course.resources;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.User;
import com.udemy.course.services.CategoryService;
import com.udemy.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //indica pro spring que ele é um controller
@RequestMapping(value = "/categories") //endpoint
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping //indica que o tipo de request é get
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
