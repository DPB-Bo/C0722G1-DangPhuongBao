package com.codegym.ex_1.controller;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.model.Category;
import com.codegym.ex_1.service.IBlogService;
import com.codegym.ex_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("findAll")
    public ResponseEntity<List<Blog>> getFindAll(){
        return new ResponseEntity<>(blogService.findAll(),HttpStatus.OK);
    }

//    @GetMapping("")
//    public ResponseEntity<Page<Blog>> getList(@PageableDefault(size = 3) Pageable pageable, ModelMap model) {
//        Page<Blog> blogList = blogService.findByDeleted(pageable);
//        if (blogList == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("{search}")
    public ResponseEntity<Page<Blog>> getListSearchEd(@PageableDefault(size = 3) Pageable pageable, @PathVariable String search) {
        if (search == null) {
            search = "";
        }
        Page<Blog> blogList = blogService.findByTitleContainingOrAuthorContaining(search, pageable);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("{idCategory}/{page}")
    public ResponseEntity<Page<Blog>> getListByCategory(@PathVariable("idCategory") int idCategory, @PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page, 3);
        Category category = categoryService.findById(idCategory);
        Page<Blog> blogList = blogService.findByCategory(category, pageable);
        if (blogList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


    @PatchMapping("/delete/{id}")
    public ResponseEntity<Blog> softDelete(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


}
