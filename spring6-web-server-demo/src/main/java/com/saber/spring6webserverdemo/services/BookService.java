package com.saber.spring6webserverdemo.services;

import com.saber.spring6webserverdemo.model.query.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book entity);
    Optional<Book> findById(Long id);
    List<Book> findAll();
}
