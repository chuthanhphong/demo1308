package com.codegym.demo1308.model.service.product;

import com.codegym.demo1308.model.Product;
import com.codegym.demo1308.model.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findByName(String name);
}
