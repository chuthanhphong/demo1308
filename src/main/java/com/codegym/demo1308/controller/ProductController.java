package com.codegym.demo1308.controller;

import com.codegym.demo1308.model.Product;
import com.codegym.demo1308.model.service.Category.ICategoryService;
import com.codegym.demo1308.model.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("**")
@RequestMapping("/products")

public class ProductController {

//    @Autowired
//    ICategoryService categoryService;
    @Autowired
    IProductService productService;


    @GetMapping("/list")
    public ResponseEntity<Iterable<Product>> findAll(){
        List<Product> productList = (List<Product>) productService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
       productService.save(product);
        return new ResponseEntity(productService.findById(product.getId()),HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        product.setId(id);
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Product>> searchProduct(@PathVariable String name){
        Iterable<Product> products = productService.findByName(name);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
