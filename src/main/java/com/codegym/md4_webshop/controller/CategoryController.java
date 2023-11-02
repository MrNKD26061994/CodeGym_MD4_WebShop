package com.codegym.md4_webshop.controller;

import com.codegym.md4_webshop.model.Category;
import com.codegym.md4_webshop.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController implements IGeneralController<Category> {
    @Autowired
    private ICategoryService categoryService;
    @Override
    public ResponseEntity<Iterable<Category>> list() {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity create(Object o) {
        return null;
    }

    @Override
    public ResponseEntity update(Object o) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }
}
