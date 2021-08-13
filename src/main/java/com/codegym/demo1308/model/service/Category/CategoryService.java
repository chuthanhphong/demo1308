package com.codegym.demo1308.model.service.Category;

import com.codegym.demo1308.model.Category;
import com.codegym.demo1308.model.service.IGeneralService;
import com.codegym.demo1308.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<Category> findbyName(String name) {
        return categoryRepository.findAllByNameContaining(name);
    }
}
