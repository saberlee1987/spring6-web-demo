package com.saber.spring6webserverdemo.services.impl;

import com.saber.spring6webserverdemo.model.query.Book;
import com.saber.spring6webserverdemo.repositories.BookRepository;
import com.saber.spring6webserverdemo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book save(Book entity) {
        return bookRepository.save(entity);
    }
    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
