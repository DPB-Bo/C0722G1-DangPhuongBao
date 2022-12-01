package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void reduceQuantity(Integer id) {
        bookRepository.reduceQuantity(id);
    }

    @Override
    public void increaseQuantity(Integer id) {
        bookRepository.increaseQuantity(id);
    }
}
