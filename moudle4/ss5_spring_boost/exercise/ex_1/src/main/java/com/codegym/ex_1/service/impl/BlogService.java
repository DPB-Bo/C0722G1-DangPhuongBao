package com.codegym.ex_1.service.impl;

import com.codegym.ex_1.model.Blog;
import com.codegym.ex_1.repository.IBlogRepository;
import com.codegym.ex_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> findByTitleContainingOrAuthorContaining(String name) {
        return blogRepository.findByTitleContainingOrAuthorContaining(name,name);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        if (blogRepository.findById(id).isPresent()){
            return blogRepository.findById(id).get();
        }else {
            return new Blog();
        }
    }

}
