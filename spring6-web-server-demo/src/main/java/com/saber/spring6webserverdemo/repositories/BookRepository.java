package com.saber.spring6webserverdemo.repositories;

import com.saber.spring6webserverdemo.model.query.Book;

import java.util.Optional;

public interface BookRepository {
     Book save(Book entity);
     Optional<Book> findById(Long id);
}
