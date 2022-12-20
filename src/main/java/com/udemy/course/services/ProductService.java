package com.udemy.course.services;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.Product;
import com.udemy.course.repositories.CategoryRepository;
import com.udemy.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //regista como serviço para ser injetado com o Autowired(Injeção de dependencia) nesse caso no ProductResource
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }


}
