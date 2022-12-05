package com.codegym.ex_1.controller;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import com.codegym.ex_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("{page}")
    public ResponseEntity<Page<Category>> getList(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Category> categories = categoryService.findByDeleted(pageable);
        if (categories == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
}
