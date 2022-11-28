package com.codegym.ex_1.controller;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.service.IBlogService;
import com.codegym.ex_1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView display(@RequestParam(defaultValue = "") String search, @PageableDefault(page = 0, size = 3)Pageable pageable){
        Blog blog = new Blog();
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("search",search);
        modelAndView.addObject("categorys",categoryService.categoryList());
        modelAndView.addObject("blog",blog);
        modelAndView.addObject("blogList",blogService.findByTitleContainingOrAuthorContaining(search,pageable));
        return modelAndView;
    };

    @PostMapping("save")
    public String save(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }


}
