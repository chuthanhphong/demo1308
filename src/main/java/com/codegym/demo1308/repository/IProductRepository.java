package com.codegym.demo1308.repository;

import com.codegym.demo1308.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {

    Iterable<Product> findProductByNameContaining(String name);
}
