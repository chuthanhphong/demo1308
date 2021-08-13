package com.codegym.demo1308.repository;

import com.codegym.demo1308.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Iterable<Category> findAllByNameContaining(String name);
}
