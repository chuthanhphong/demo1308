package com.codegym.demo1308.model.service.product;

import com.codegym.demo1308.model.Product;
import com.codegym.demo1308.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService  {
    @Autowired
    IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
       return (List<Product>) productRepository.findProductByNameContaining(name);
    }
}
