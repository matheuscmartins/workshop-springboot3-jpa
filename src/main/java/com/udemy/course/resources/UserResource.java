package com.udemy.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udemy.course.entities.User;
import com.udemy.course.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController //indica pro spring que ele é um controller
@RequestMapping(value = "/users") //endpoint
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping //indica que o tipo de request é get
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody //para indicar que o Json sera desserializado para User
                                       User obj) {
        obj = service.insert(obj);
       //return ResponseEntity.ok().body(obj); nesse caso é utilziado para retornar um status 200 de ok

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //esse caso pega o id do obj e transforma pro tipo URI.
        return ResponseEntity.created(uri).body(obj); // salva no DB e retorna status 201 de created
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.noContent().build(); //status 204
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
