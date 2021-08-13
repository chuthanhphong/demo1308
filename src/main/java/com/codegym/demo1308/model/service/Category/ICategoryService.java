package com.codegym.demo1308.model.service.Category;

import com.codegym.demo1308.model.Category;
import com.codegym.demo1308.model.service.IGeneralService;

public interface ICategoryService  extends IGeneralService<Category> {
    Iterable<Category> findbyName(String name);

}
