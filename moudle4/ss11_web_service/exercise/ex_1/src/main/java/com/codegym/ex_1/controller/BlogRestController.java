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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("{page}")
    public ResponseEntity<Page<Blog>> getList(@PathVariable("page") int page) {
        Pageable pageable = PageRequest.of(page,3);
        Page<Blog> blogList = blogService.findByDeleted(pageable);
        if (blogList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("{idCategory}/{page}")
    public ResponseEntity<Page<Blog>> getListByCategory(@PathVariable("idCategory") int idCategory,@PathVariable("page") int page){
        Pageable pageable = PageRequest.of(page,3);
        Category category = categoryService.findById(idCategory);
        Page<Blog> blogList = blogService.findByCategory(category,pageable);
        if (blogList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<Blog> softDelete(@PathVariable("id") int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteById(id);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }


}
