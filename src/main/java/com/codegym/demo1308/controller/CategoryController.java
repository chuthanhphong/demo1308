package com.codegym.demo1308.controller;

import com.codegym.demo1308.model.Category;
import com.codegym.demo1308.model.service.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("**")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<Iterable<Category>> list(){
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity(categoryService.findById(category.getId()),HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable Long id,@RequestBody Category category){
        Optional<Category> category1 = categoryService.findById(id);
        if (!category1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        category.setId(id);
        categoryService.save(category);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Category>> searchByName(@PathVariable String name){
        Iterable<Category>  categories = categoryService.findbyName(name);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

}
