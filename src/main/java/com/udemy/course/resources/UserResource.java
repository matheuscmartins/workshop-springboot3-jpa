package com.udemy.course.resources;

import com.udemy.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica pro spring que ele é um controller
@RequestMapping(value = "/users") //endpoint
public class UserResource {

    @GetMapping //indica que o tipo de request é get
    public ResponseEntity<User> findAll(){
    User user  = new User(1L,"Maria", "maria@gmail.com","99999999","12345");
    return  ResponseEntity.ok().body(user);
    }
}
