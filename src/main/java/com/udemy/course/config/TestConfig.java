package com.udemy.course.config;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //indica pro spring que é uma classe config
@Profile("test") //indica pro spring que só deve rodar quando estiver no perfil de teste do application.properties
public class TestConfig implements CommandLineRunner { //interface que roda toda vez quando iniciado

    @Autowired //indica injeção de dependencia, o spring instancia o user repository
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
    /*todo comando nesse metodo será rodado quando inciado */
}
